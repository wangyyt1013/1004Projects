import java.util.Scanner;
public class Test{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter:");
        int input = in.nextInt();
        System.out.println(String.format("%05d", input));
    }
}