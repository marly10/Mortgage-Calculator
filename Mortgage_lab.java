/*
Ricky McKenzie
Lab-CSC1043
*/

//importing java libraries
import java.util.Scanner;
import java.text.DecimalFormat;

public class Mortgage_lab {

   public static void main(String args[]){
 
      Scanner sc = new Scanner(System.in);
      DecimalFormat format = new DecimalFormat("$#,###.00");
 
      //header
      System.out.println("Please enter the values requested for the 2 loans you wish to compare" );
      
      //ask users for loan pricipal to compute entire system/process
      System.out.print("\nWhat is the amount of the loan?  ");
      double loan_principal = sc.nextDouble(); 
 
      //header
      System.out.println("\nFirst set of terms" );

      //ask users for loan term to compute entire system/process (first part)
      System.out.print("Annual interest rate (Ex. 3.5%): ");
      String loan_percentage_rate = sc.next(); 
      
      //finding the index on percent sign(location of where they exist with in the string data)  (first part)
      int percent_sign = loan_percentage_rate.indexOf('%');
      String rate_string = loan_percentage_rate.substring(0, percent_sign);
      
      //Parses the term inputed as a string by user. Using the parseDouble() method (first part)
      double parsed_rate = Double.parseDouble(rate_string);
      
      //parses the term to decimal. 5.25% =  0.0525%
      double rate_convertion = parsed_rate/100/12;

      //the duration of the loan in months (120 would be 10 years, for example)
      System.out.print("Number of months: ");
      int months = sc.nextInt(); 
      
 

      //equation for monthly loan payment for first payment
      double payment = (loan_principal * rate_convertion) / (1 - Math.pow(1 + rate_convertion, - months));
      
      //header
      System.out.println("\nSecond set of terms" );
      
      //ask users for loan term to compute entire system/process (second part)
      System.out.print("Annual interest rate (Ex. 3.5%): ");
      String loan_percentage_rate_2 = sc.next(); 
      
      //finding the index on percent sign(location of where they exist with in the string data)  (second part)
      int percent_sign_2 = loan_percentage_rate_2.indexOf('%');
      String rate_string_2 = loan_percentage_rate_2.substring(0, percent_sign_2);
      
      //Parses the term inputed as a string by user. Using the parseDouble() method (second part)
      double parsed_rate_2 = Double.parseDouble(rate_string_2);
      
      //parses the term to decimal. 5.25% =  0.0525%
      double rate_convertion_2 = parsed_rate_2/100/12;
      
      //the duration of the loan in months (120 would be 10 years, for example)
      System.out.print("Number of months: ");
      int months_2 = sc.nextInt(); 
    
      //equation for monthly loan payment for second payment
      double payment_2 = (loan_principal * rate_convertion_2) / (1 - Math.pow(1 + rate_convertion_2, - months_2));
      
      //over all loan payment for first interest and month
      double total_payment = payment * months;
      
      //over all loan payment for second interest and month
      double total_payment_2 = payment_2 * months_2;

      //System print out of the entire system
      System.out.println("\nThe monthly payment for loan 1 is " + format.format(payment)                         +     
                         "\nThe monthly payment for loan 2 is " + format.format(payment_2)                         +   
                         "\nTherefore your minimum payment would be " +format.format(Math.min(payment, payment_2)) +
                         "\nWith the first loan, you would be paying a total of " + format.format(total_payment)   +
                         "\nWith the first loan, you would be paying a total of " + format.format(total_payment_2)
      );

   }
}