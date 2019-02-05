/*****************************************
 * This program coordinates the moves of human and computer players to 
 * run the Nim game and decide the winner.
 * 
 * @author Yuanyuting Wang
 * @date 10/15/2018
 ****************************************/ 

public class Game{
    
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    
    public Game(int difficulty){
        
        marbles = (int) ((Math.random()*90+10));//number of marbles randomly generated in range [10,100].
        computerPlayer = new Computer(difficulty);//player chooses difficulty level before game starts.
        humanPlayer = new Human();
        
    }
    
    //run the Nim game.
    public void play(){
        
        //determine who takes the first round.
        int firstRound = (int)(Math.round(Math.random()));
        if (firstRound == 1){
            System.out.println("The human player takes the first move!");
        }
        else {
            System.out.println("The computer player takes the first move!");
        }
        
        //keep count of the number of rounds.
        int rounds = 0;
        
        //initiate new rounds until only one marble is left.
        while (marbles > 1){
            
            if ((firstRound + rounds) % 2 == 1){//human player's turn.
                System.out.println("The number of marbles left is: "+ marbles);
                System.out.print("Please input the number of marbles you want to remove:");
                humanPlayer.move(marbles);//this method saves user's inputted answer to the prompt and returns user's choice. 
                marbles -= humanPlayer.getChoice();
            }
            
            else {//computer player's turn
                computerPlayer.move(marbles);
                marbles -= computerPlayer.getChoice();
            }
            
            rounds++;//continues the while loop.
        }
        
        getWinning(rounds, firstRound);       
    
    }
    
    //print winning message.
    private void getWinning(int rounds, int firstRound){
        
        if ((rounds+firstRound)%2==0){//human player has the last round.
            System.out.println("The human player has won!");
        }
        
        else {//computer player has the last round.
            System.out.println("The computer player has won!");
        }
    }


}