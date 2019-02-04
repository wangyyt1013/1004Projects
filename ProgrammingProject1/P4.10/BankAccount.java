/**
 * This program provides information of a bank account.
 */

public class BankAccount{
    private double balance;
    private double interest;
    public BankAccount(double[] value){
        balance = value[0];
        interest = value[1]/1200;
    }
    public double getBalance(int n){
        for (int i=1;i<=n;i++){
            balance = balance + balance * interest;
        }
        return balance;
    }
}