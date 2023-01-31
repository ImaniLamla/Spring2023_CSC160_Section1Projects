
import java.util.Scanner; //imports the scanner class to use the scanner object and its functions

/***********************************************************************************************************************************************************************************
Description:			This program calculates the total the user should pay for an invoice after a discount has been calculated. The discount percent is based on the subtotal 
						the user enters. The program allows the user to input as many line items as they want per invoice and it allows them to input multiple invoices. A summary
						,which includes the amount before and after the discount as well as the discount percent, is displayed after each invoice. Another summary is dispalyed at 
						the end of the program which includes the number of invoices and the averages of all the invoices and discounts. 
Progtammer's Name:		Imani Lamla
Date Written:			2023.01.27
GitHub Repository URL:	https://github.com/ImaniLamla/Spring2023_CSC160_Section1Projects.git 
***********************************************************************************************************************************************************************************/

public class InvoiceApp {

    public static void main(String[] args) {
		
		// create a Scanner object named sc
        Scanner sc = new Scanner(System.in);
		
		// initialize variables for use in calculating averages
		int invoiceCount = 0;						//stores the number of invoices
		int numLineItems = 0;						//stores the number of line items per invoice
        
		double discountAmount = 0.0;				//stores the amount that will be taken off the subtotal
		double discountInvoiceTotal = 0.0;			//stores the amount that the user has to pay after the discount 
		double discountPercent = 0.0;				//stores the percentage that will be taken off from the subtotal. Used to calculate discountAmount
        double discountTotal = 0.0;					//stores the total amount of the discounts that the user gets for all invoices
		double invoiceTotal = 0.0;					//stores the total amount after the discount that the user has to pay for all invoices
		double subtotal = 0.0;						//stores the price of the line items before the discount has been calculated 
		double sumSubtotal = 0.0;					//stores the sum of the subtotals for each invoice
		
        
		String choice = "y";						//stores the user's choice to either continue the program and add another invoice or end it
		
        // welcome the user to the program
		System.out.println("*******************************************");
        System.out.println("* Welcome to the Invoice Total Calculator *");
		System.out.println("*******************************************");

        System.out.println();  // print a blank line

        // perform invoice calculations until choice is "n" or "N". Allows user to enter many invoices
        
        while (!choice.equalsIgnoreCase("n")) {
			
            // get the number of line items from the user
            System.out.print("Enter the number of line items:   ");
            numLineItems = sc.nextInt();
            System.out.println();
			
			//Allows the user to enter as many line items as they want per invoice
			for (int i = 1; i <= numLineItems; i++){
				System.out.print("Enter the #" + i + " line item:   ");
				subtotal = sc.nextDouble();
				sumSubtotal = sumSubtotal + subtotal;
				
			}//end of for loop
			
			System.out.println(); 
			System.out.println("*******************************************");
			System.out.println();

            // uses the sumSubtotal to determine the discount percent then calculates the discount amount and total
            if (sumSubtotal >= 500) {
                discountPercent = 0.25;
            } else if (sumSubtotal >= 200) {
                discountPercent = 0.2;
            } else if (sumSubtotal >= 100) {
                discountPercent = 0.1;
            } else {
                discountPercent = 0.0;
            }
            discountAmount = sumSubtotal * discountPercent;
            discountInvoiceTotal = sumSubtotal - discountAmount;
            
            // accumulate the invoice count and invoice total
            invoiceTotal = invoiceTotal + discountInvoiceTotal;
            discountTotal = discountTotal + discountAmount;
            invoiceCount = invoiceCount + 1;  

            // display the discount amount and total
            System.out.printf("%20s: %,10.2f\n", "Subtotal", sumSubtotal);
            System.out.printf("%20s: %,10.2f\n", "Discount Percent", discountPercent);
            System.out.printf("%20s: %,10.2f\n", "Discount amount", discountAmount);
            System.out.printf("%20s: %,10.2f\n", "Invoice total", discountInvoiceTotal);     
            
            System.out.println();
            System.out.println("*******************************************");
            System.out.println();

			sumSubtotal = 0.0; //clears the sum of the subtotals to start fresh when calculating the sum of the subtotals for the next invoice

            choice = sc.nextLine(); // clear return character still in input buffer

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
            System.out.println("*******************************************");
            System.out.println();
            
        }//end of while loop
		
		sc.close(); //closes the scanner object
        
        // calculate and display invoice count, average invoice, and average discount
		System.out.printf("%20s: %,10d\n", "Number of invoices", invoiceCount);
		System.out.printf("%20s: %,10.2f\n", "Average invoice", invoiceTotal / invoiceCount);
		System.out.printf("%20s: %,10.2f\n", "Average discount", discountTotal / invoiceCount);
		
		System.out.println();
		System.out.println("*******************************************");
		System.out.println();
		
		// prints a goodbye message 
		System.out.println("Goodbye!! Hope to see you soon.");
        
    }//end of main
}//end of class