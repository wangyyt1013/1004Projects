import java.util.Scanner;

public class getBalance{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please input initial balance:");
        double balance = in.nextDouble();
        System.out.print("Please input annual interest rate (unit:%):");
        double interest = in.nextDouble();
        System.out.print("Please input an integral number of months:");
        int months = in.nextInt();
        double[] value = {balance, interest};
        BankAccount object = new BankAccount(value);
        double result = object.getBalance(months);
        System.out.println("The balance after " + months + " months is: " + result);
    }
}