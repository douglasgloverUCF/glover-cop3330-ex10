/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Douglas Glover
 */
package base;
import java.util.Scanner;
/*
Working with multiple inputs and currency can introduce some tricky precision issues.

Create a simple self-checkout system. Prompt for the prices and quantities of three items. Calculate the subtotal of the items.
Then calculate the tax using a tax rate of 5.5%. Print out the line items with the quantity and total,
and then print out the subtotal, tax amount, and total.

Example Output

Enter the price of item 1: 25
Enter the quantity of item 1: 2
Enter the price of item 2: 10
Enter the quantity of item 2: 1
Enter the price of item 3: 4
Enter the quantity of item 3: 1
Subtotal: $64.00
Tax: $3.52
Total: $67.52

Constraints

Keep the input, processing, and output parts of your program separate. Collect the input, then do the math operations and string building,
and then print out the output.
Be sure you explicitly convert input to numerical data before doing any calculations.

Challenges

Revise the program to ensure that prices and quantities are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
Alter the program so that an indeterminate number of items can be entered. The tax and total are computed when there are no more items to be entered.
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();
        int[] price = new int[3];
        int[] quantity = new int[3];
        for(int i = 0; i < 3; i++) {
            price[i] = myApp.getPrice(i);
            quantity[i] = myApp.getQuantity(i);
        }
        String message = myApp.checkOut(price, quantity);
        myApp.output(message);
    }
    int getPrice(int i)
    {
        System.out.print("Enter the price of item " + (i + 1) + ": ");
        return in.nextInt();
    }
    int getQuantity(int i)
    {
        System.out.print("Enter the quantity of item " + (i + 1) + ": ");
        return in.nextInt();
    }
    String checkOut(int[] price, int[] quantity)
    {
        double subtotal = 0;
        double tax, total;
        for(int i = 0; i < 3; i++) {
            subtotal += price[i] * quantity[i];
        }
        tax = subtotal * 0.055;
        total = subtotal + tax;
        return String.format("""
        Subtotal: $%.2f
        Tax: $%.2f
        Total: $%.2f
        """, subtotal, tax, total);
    }
    void output(String message)
    {
        System.out.print(message);
    }
}
