/**
 * This class calculaes the date of Easter 
 * Sunday in a given year.
 */

public class EasterSunday{
  
    private int month;
    private int day;
  
    public EasterSunday(){
        month = 0;
        day = 0;
    }
    
    public static int[] getDate(int year){
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8*b+13)/25;
        int h = (19*a+b-d-g+15)%30;
        int j = c /4;
        int k = c % 4;
        int m = (a + 11*h ) / 319;
        int r = (2*e + 2*j-k-h+m+32)%7;
        int n = (h-m+r+90)/25;
        int p = (h-m+r+n+19)%32;
        int[] ret = {n,p};
        return ret;
    }
}