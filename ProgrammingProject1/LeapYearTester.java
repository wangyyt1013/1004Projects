/**
*
* This class is the tester for the leap year program.
* You should not make any changes to this class.
*
* @author: <Yuanyuting Wang>
* @date: <20180918>
*
*/

import java.util.Scanner;

public class LeapYearTester{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a year");
        int year_input = input.nextInt();

        // now make a Year object

        Year theYear = new Year(year_input);

        // now check to see if it's a leap year

        if (theYear.isLeapYear())
            System.out.println("That's a leap year!");
        else
            System.out.println("That's not a leap year!");
    }
}



