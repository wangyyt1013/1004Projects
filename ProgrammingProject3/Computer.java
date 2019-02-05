/*****************************************
 * A program that simulates the action of the computer player of the Nim game.
 * 
 * @author Yuanyuting Wang
 * @date 10/15/2018
 ****************************************/ 
import java.util.*;

public class Computer{
    
    private int mode;//1 is stupid mode, 2 is smart mode.
    private int choice;//the number of marbles the computer removes.
    
    public Computer(int m){
        mode = m;
        choice = -1;
    }
    
    //stupid: computer picks one random integer between 1 and n/2.
    private void stupid(int n){
        choice = (int) (Math.random()*(n/2-1)+1);
    }
    
    //smart: computer always leaves 2^k-1 marbles (the winning strategy).
    private void smart(int n){
        
        //find the biggest k so that 2^k-1 < n. 
        double rawPower = Math.log(n+1)/Math.log(2);
        if (rawPower%1 == 0){
            rawPower -= 1;
        }
        int power = (int) (rawPower);
        
        //remove certain marbles so that there are 2^k-1 marbles left.
        int remove = (int) (Math.pow(2,power))-1;
        choice = n - remove;
    }
    
    //chooses computer's move for each round based on difficulty level.
    public void move(int marbles){
        
        if (mode == 1){
            this.stupid(marbles);
        }
        else {
            this.smart(marbles);
        }
        
    }
    
    //accss computer's choice.
    public int getChoice(){
        return choice;
    }
    
    
}
