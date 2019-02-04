/**
 * This class takes two points in time and determines
 * which point comes first.
 */

public class Time{
    public int getFirst(String[] time){
        int hour1 = Integer.parseInt(time[0].substring(0,2));
        int hour2 = Integer.parseInt(time[1].substring(0,2));
        int minute1 = Integer.parseInt(time[0].substring(2,4));
        int minute2 = Integer.parseInt(time[1].substring(2,4));
        if (hour1 < hour2){
            return 0;
        }
        else if (hour1 == hour2){
            if (minute1 < minute2){
                return 0;
            }
            else if (minute1 == minute2){
                return 2;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
}