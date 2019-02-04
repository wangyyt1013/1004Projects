import java.util.Scanner;

public class RomanNumber{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an integral number:");
        int number = in.nextInt();
        int part0 = number / 1000;
        int part1 = (number % 1000)/100;
        int part2 = (number % 100)/10;
        int part3 = number % 10;
        int[] part = {part0, part1, part2, part3};
        String[][] catalogue = {{"M", " ", " "},
                                {"C", "D", "M"},
                                {"X", "L", "C"},
                                {"I", "V", "X"}};
        String finalString = " ";
        for (int i=0;i<=3;i++){
            getNumber_new string = new getNumber_new(catalogue[i]);
            String newstring = string.convert(part[i]);
            finalString += newstring;
        }
        System.out.println(finalString.trim());
    }
}