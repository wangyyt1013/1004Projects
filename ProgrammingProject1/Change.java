/**
 * This program determines how to provide change given the amount received
 * and the amount due.
 * 
 * @author: <Yuanyuting Wang>
 * @date: <20180918>
 */

import java.util.Scanner;

public class Change{
  
    public static void main(String[] args){

        // your code here!
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the amount due (in pennies):");
        int amountDue = in.nextInt();
        System.out.print("Enter the amount paid (in pennies):");
        int amountPaid = in.nextInt();
        int change = amountPaid - amountDue;
        final int penniesPerDollar = 100;
        final int quartersPerDollar = 25;
        final int dimesPerDollar = 10;
        final int nickelsPerDollar = 5;
        int dollars = change / penniesPerDollar;
        int penniesLeft1 = change % penniesPerDollar;
        int quarters = penniesLeft1 / quartersPerDollar;
        int penniesLeft2 = penniesLeft1 % quartersPerDollar;
        int dimes = penniesLeft2 / dimesPerDollar;
        int penniesLeft3 = penniesLeft2 % dimesPerDollar;
        int nickels = penniesLeft3 / nickelsPerDollar;
        int pennies = penniesLeft3 % nickelsPerDollar;
        System.out.println("The change given is: \nDollars: " + dollars + "\nQuarters:"
                          + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels 
                          + "\nPennies: " + pennies);

    }





}	
