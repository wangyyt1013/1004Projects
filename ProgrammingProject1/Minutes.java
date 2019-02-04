/**
 * This program converts a number of hours, days, and years into minutes.
 * 
 * @author: <Yuanyuting Wang>
 * @date: <20180918>
 */

import java.util.Scanner;

public class Minutes{
    
    public static void main(String[] args){
        
        //your code here
        
        Scanner in = new Scanner(System.in);
        
        //read the number of years, weeks and days
        
        System.out.print("Please input the number of years (must be nonnegative intergal):");
        int years = in.nextInt();
        System.out.print("Please input the number of weeks (must be nonnegative intergal):");
        int weeks = in.nextInt();
        System.out.print("Please input the number of days (must be nonnegative intergal):");
        int days = in.nextInt();
        
        //compute the number of minutes in the given time
        
        final int daysPerYear = 365;
        final int daysPerWeek = 7;
        final int minutesPerDay = 1440;
        int totalDays = years * daysPerYear + weeks * daysPerWeek + days;
        int minutes = totalDays * minutesPerDay;
        
        //print number of minutes
        
        System.out.println("The number of minutes in the given amount of time is: " + minutes);
    }
}
