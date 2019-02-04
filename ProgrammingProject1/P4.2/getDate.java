import java.util.Scanner;

public class getDate{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an integral year:");
        int year = in.nextInt();
        EasterSunday date = new EasterSunday();
        int[] EasterSunday = date.getDate(year);
        System.out.println("This year's date for the Easter Sunday is:\nMonth: " + EasterSunday[0] + "\nDay: " + EasterSunday[1]);
    }
}