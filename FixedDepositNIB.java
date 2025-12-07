import java.util.Scanner;

/**
 * Write a description of class FixedDepositNIB here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FixedDepositNIB
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      
      int choice = 1; // 1= continue ,0 = stop
      
      System.out.println("-------NIB Fixed Deposit Calculator-------");
      
      while(choice == 1)
      {
          System.out.println("\nEnter deposit amount (minimum Rs.1000):");
          double P = sc.nextDouble();
          
          if(P<1000)
          {
              System.out.println("Error:Minimum deposite is Rs.1000");
              continue;
          }
          
          System.out.println("Enter duration in years(Max 5 years):");
          int years = sc.nextInt();
          
          if(years<1||years>5)
          {
              System.out.println("Error:Duration must be between 1 and 5 years.");
              continue;
          }
          
          System.out.println("Enter annual interest rate(8-12%):");
          double annualRate = sc.nextDouble();
          
          if(annualRate<8||annualRate>12)
          {
              System.out.println("Error:Rate must be between 8% to 12%.");
              continue;
          }
          //monthly interest rate
          double monthlyRate = annualRate/12/100;
          
          //Total months
          int months = years*12;
          
          //calculating compound interest
          double A = P;
          for(int i = 1;i<=months;i++)
          {
              A = A + (A * monthlyRate); // formula A = A*(1+R)
          }
          
          // processing fee (0.5%)
          double feeRate = 0.005;
          double fee = A*feeRate;
          
          //Final ammount after fee deduction
          double FinalAmount = A - fee;
          
          System.out.println("\n--- FD Calculation Result ---");
          System.out.println("Principal (P): Rs. " + P);
          System.out.println("Annual Rate: " + annualRate + "%");
          System.out.println("Monthly Rate: " + monthlyRate);
          System.out.println("Duration: " + years + " years (" + months + " months)"); //string.format displaces just few number after decimal 
          System.out.println("Maturity Amount (A): Rs. " + String.format("%.2f", A));  //making it easy to see for anyone using the program
          System.out.println("Processing Fee (0.5%): Rs. " + String.format("%.2f", fee));//It lets you control decimal places, alignment, and text .
          System.out.println("Final Amount Received: Rs. " + String.format("%.2f", FinalAmount));//formatting without printing directly
            
          System.out.println("\nDo you want to calculate again? (1 = Yes, 0 = No): ");
          choice = sc.nextInt();  
      }
      System.out.println("\nThank you for using the NIB FD Calculator!");
      sc.close();
   }
}