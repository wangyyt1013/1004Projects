import java.util.Scanner;

public class getFirst{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the first point of time");
        String time1 = in.next();
        System.out.print("Please enter the second point of time");
        String time2 = in.next();
        String[] time = {time1, time2};
        Time early_time = new Time();
        int result = early_time.getFirst(time);
        String[] selection = {time1, time2, "Time1 and time2 are the same."};
        System.out.println(selection[result]);
    }
}
