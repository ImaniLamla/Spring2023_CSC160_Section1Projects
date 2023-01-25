/*
 Description:			This program uses the discount percent based on the amount that the user entered
 						to calculate how much they have to pay with that discount. It also allows the 
 						user to enter as many invoices as they want and displays a summary including the 
 						average invoice and average discount earned.
 Programmer:			Imani Lamla 
 Date:					24 January 2023
 GitHub Repository URL: https://github.com/ImaniLamla/Spring2023_CSC160_Section1Projects.git
 */
import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
    	
    	//initialize variables for use in calculating averages
    	int invoiceCount = 0;				//stores the number of invoices     
    	
    	double discountAmount = 0.0;		//stores how much money gets deducted from the subtotal
    	double discountPercent = 0.0;		//stores the percentage of the user's discount based off the subtotal
    	double discountTotal = 0.0;			//stores the total amount of money that is deducted 
        double invoiceTotal = 0.0;			//stores the total amount of money the user pays in the end with the discounts added
        double subtotal = 0.0;				//stores the initial amount that the user has to pay before the discount has been added
        double total = 0.0;					//stores the amount of money the user has to pay after the discount has been applied 
        
        //create a Scanner object named sc
        Scanner sc = new Scanner(System.in);
        
        String choice = "y";				//stores the user's choice to either continue running the program or not
        String input = "";					//will store the amount that the user has to pay in the invoice
        String message = "";				//will store the summary of the user's invoices
        
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator v2");
        System.out.println();  // print a blank line

        // perform invoice calculations until choice is "n" or "N" 
        while (!choice.equalsIgnoreCase("n")) {
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            input = sc.nextLine();
            subtotal = Double.parseDouble(input);

            // calculate the discount amount and total
            if (subtotal >= 500) {
                discountPercent = .25;
            } else if (subtotal >= 200) {
                discountPercent = .2;
            } else if (subtotal >= 100) {
                discountPercent = .1;
            } else {
                discountPercent = 0.0;
            }
            discountAmount = subtotal * discountPercent;
            total = subtotal - discountAmount;
            
            // accumulate the invoice count and invoice total
            invoiceTotal = invoiceTotal + total;
            discountTotal = discountTotal + discountAmount;
            invoiceCount = invoiceCount + 1;  

            // display the discount amount and total
            message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + total + "\n";            
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
            
        }//end of while loop
        
        sc.close();//closing the scanner
        
        // calculate and display invoice count, average invoice, and average discount
        message = "Number of invoices: " + invoiceCount + "\n"
                       + "Average invoice:    " + invoiceTotal / invoiceCount + "\n"
                       + "Average discount:   " + discountTotal / invoiceCount + "\n";
        System.out.println(message);
        
    }//end of main
    
}//end of class