/*****************************************
 * A program that simulates the action of the human player of the Nim game.
 * 
 * @author Yuanyuting Wang
 * @date 10/15/2018
 ****************************************/ 
import java.util.Scanner;

public class Human{
   
    private int choice;
    private Scanner input;
    private int marbles;
    
    public Human(){
        input=new Scanner(System.in);//used for inputting player's choice.
        choice = -1;//the number of marbles the player chooses to remove.
    }
    
    //ask the player to input choice (within a cetain range) for each round.
    public void move(int marbles){
    
        int remove = input.nextInt();
        if (remove > 0 && remove <= marbles/2){
            choice = remove;
        }
        else{//if player's choice exceeds given range, print error message and calls the method again.
            System.out.print("Sorry, you can only take at least one and at most half of the marbles!" +
                             "\nPlease input number of marbles to remove again:");
            this.move(marbles);
        }
    }
    
    //access player's choice.
    public int getChoice(){
        return choice;
    }
    
    
}
