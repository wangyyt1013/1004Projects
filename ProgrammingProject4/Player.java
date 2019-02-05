/* 
 * This class simulates a Video Poker player with a hand of 5 cards,
 * a certain amount of bankroll to start with, and who makes a bet
 * for each round of the game.
 * 
 * @author: Yuanyuting Wang (yw3241)
 * @date: 2018.11.02
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Player {
	
	Scanner in = new Scanner(System.in);	
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;
		
	public Player(double userBankroll){		
	    // create a player here
	    
	    hand = new ArrayList<Card>();
        bankroll = userBankroll;
        bet = 0;
	}
    
    public void setBankroll (double amt){
        // mutate the value of bankroll
        
        bankroll = amt;
    }
    
    public void bets(double amt){
        // player makes a bet

        bet = amt;
        bankroll -= amt;
    }
    
	public void addCard(Card c){
	    // add the card c to the player's hand
	    
	    hand.add(c);
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
	    
	    hand.remove(c);
        }

    public void sort(){
        // sort hand cards in ascending order according to rank and suit
        
        Collections.sort(hand);
    }
       
    public void winnings(double odds){
        //	adjust bankroll if player wins
        
        bankroll += odds * bet;
    }

    public void printHand(){
        // print out the index and value of each card
        
        System.out.println("=========================");
        System.out.println("Your current hand is: ");
        for (int i = 0; i < hand.size(); i++){
            System.out.println(i+1 + ": " + hand.get(i).toString());
        }
        System.out.println("=========================");
    }
    
    public double getBankroll(){
        // return current balance of bankroll
        return bankroll;
    }
    
    
    public ArrayList<Card> getHand(){
        // access the hand cards array list
        
        return hand;
    }
    
    public double getBet(){
        // access the amount of bet the user has made
        
        return bet;
    }

}


