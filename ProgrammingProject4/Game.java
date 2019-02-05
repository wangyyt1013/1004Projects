/* 
 * This class runs the Video Poker Game by taking user input, creating 
 * user's hand of cards, and then evaluating the cards and changing the 
 * user bankroll accordingly.
 * 
 * @author: Yuanyuting Wang (yw3241)
 * @date: 2018.11.02
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	
    Scanner in = new Scanner(System.in);
	private Player p;
	private Deck cards;
    private final int HAND_NUMBER = 5;
    private boolean testing;
    
	public Game(String[] testHand){
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
        
        cards = new Deck();
        testing = true;
        
        // Initialize bankroll after making sure its value is larger than 1
        System.out.print("Welcome to video poker! Please set your bankroll " + 
                         "(preferably larger than 5): " );
        double userBankroll = qualifyBankroll(in.nextDouble());
        p = new Player(userBankroll);
        
        // Translate each item in testhand into a card object in the hand array
        for (String item : testHand){
            String suit = item.substring(0,1);//suit of card
            int suitInt = 0;
            int rank = Integer.valueOf(item.substring(1, item.length()));//rank of card
            switch(suit){
                case "c": suitInt = 1;
                    break;
                case "d": suitInt = 2;
                    break;
                case "h": suitInt = 3;
                    break;
                case "s": suitInt = 4;
                    break;
            }
            Card testCard = new Card(suitInt, rank);
            p.addCard(testCard);
        }
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
        
        // Initialize bankroll after making sure its value is larger than 1
        System.out.print("Welcome to video poker! Please set your bankroll " + 
                         "(preferably larger than 5): " );
        double userBankroll = qualifyBankroll(in.nextDouble());
        p = new Player(userBankroll);
        
        cards = new Deck();
        testing = false;
	}
	
	public void play(){
		// This method should play the game
        
        System.out.println("Your current bankroll is " + p.getBankroll() + ".");
        System.out.print("How many tokens do you want to bet? (from 1 to 5)");
        
        // Initialize bet after making sure its value is between 1 and 5
        double userBet = qualifyBet(in.nextDouble(), p.getBankroll());
        p.bets(userBet);
        System.out.println("You have betted " + p.getBet() + " tokens. "
                           + "Your current bankroll is " + p.getBankroll() + ".");
        
        if (!testing){// The case with the no-argument constructor
            
            // Shuffle and deal the cards
            cards.shuffle();
            for (int i = 0; i < HAND_NUMBER; i++){
                p.addCard(cards.deal());
            }

            // Print hand for user and let them replace cards
            p.printHand();
            replaceCards();
        }
        
        p.sort();// Sort cards for evaluation
        
        double originalBankroll = p.getBankroll();
        String result = checkHand(p.getHand());// Evaluate cards
        double odds = decideOdds(result);// Determine payout based on evaluation result
        p.winnings(odds);// Change bankroll based on evaluation result
        
        showResult(originalBankroll, result, odds);
        
        //when bankroll <= 0, stop game
        if (p.getBankroll() <= 0) {
            System.out.println("\n Unfortunately, you've run out of tokens. " +
                               "Thanks for playing though! :)");
        }
        
        // Otherwise, ask user if they wants to play again
        else {
            in = new Scanner(System.in); // Reset Scanner to accommodate new in.next()
            System.out.println("Do you want to play again? (y/n)");
            if (in.next().equals("y")){
                
                // Remove all cards in the current hand
                for (int i = 0; i < HAND_NUMBER; i++){
                    Card remove = p.getHand().get(0);
                    p.removeCard(remove);
                }
                
                this.play();
            }
            else {
                System.out.println("Thanks for playing! :)");
            }
        }
	}
    
    private double qualifyBet(double amt, double bankroll){
        // Make sure the bet entered by user is in the range 1 to 5
        
        while (amt < 1 || amt > 5 || amt > bankroll) {
            System.out.println("You should bet at least 1 token and at least 5 tokens. " + 
                               "Also, your bet should not be larger than your bankroll. "
                               + "Try again: ");
            amt = in.nextDouble();
        }
        return amt;
    }

    private double qualifyBankroll(double amt){
        // Make sure the bankroll entered by user is larger than 0
        
        while (amt < 1) {
            System.out.println("Your initial bankroll should be larger than 1. " +
                               "Try again: ");
            amt = in.nextDouble();
        }
        return amt;
    }

    private void replaceCards(){
        
        // Let users replace cards
        
        System.out.print("Do you want to replace your cards? (y/n)");

        if (in.next().equals("y")){
            System.out.println("Which cards do you want to replace? Enter card index" + 
                               "(input \"n\" to stop): ");

            // Set the conditions under which users can replace cards
            while (in.hasNextInt() && p.getHand().size() > 0) {
                Card remove = p.getHand().get(in.nextInt() - 1);// The index inputted by the 
                    // user is 1 larger than the actual index of the card.
                p.removeCard(remove);
                
                // Print current hand for user to choose whether or not to replace again
                p.printHand();
                System.out.println("Which cards do you want to replace?" +
                                   "Enter card index (input \"n\" to stop): ");
            }

            // Fill up the hand to 5 cards with newly dealed cards
            int currentNumber = HAND_NUMBER - p.getHand().size();
            for (int j = 0; j < currentNumber; j++){
                p.addCard(cards.deal());
            }
        }   
    }
    
    public String checkHand(ArrayList<Card> hand){
        // Check user's hand in a order of descending payout 
        
        String result = "";
        if (royalFlush(hand)){
            result = "Royal Flush";
        }
        else if (straightFlush(hand)){
            result = "Straight Flush";
        }
        else if (fourOfAKind(hand)){
            result = "Four of a Kind";
        }
        else if (fullHouse(hand)){
            result = "Full House";
        }
        else if (flush(hand)){
            result = "Flush";
        }
        else if (straight(hand)){
            result = "Straight";
        }
        else if (threeOfAKind(hand)){
            result = "Three of a Kind";
        }
        else if (twoPairs(hand)){
            result = "Two Pairs";
        }
        else if (onePair(hand)){
            result = "One Pair";
        }
        else {
            result = "No Pair";
        }
        return result;
	}    
                
    private ArrayList<Integer> pairCheck(ArrayList<Card> hand){
        // Return the occurrences of paired rank values in the hand
        
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        for (int i = 0; i < HAND_NUMBER - 1; i++){
            if (hand.get(i).getRank() == hand.get(i+1).getRank()){
                pairs.add(i);
            }
        }
        
        return pairs;
    }

    private boolean flush(ArrayList<Card> hand){
        // Determine if the hand is flush
        
        boolean result = true;
        for (int i = 1; i < hand.size(); i++){
            if (hand.get(0).getSuit() != hand.get(i).getSuit()){
                result = false;
            }
        }
        return result;
    }
        
    private boolean onePair(ArrayList<Card> hand){
        // Determine if the hand is One Pair
        
        ArrayList<Integer> pairs = pairCheck(hand);
        if (pairs.size() == 1){//there's only one pairs of rank values
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean twoPairs(ArrayList<Card> hand){
        // Determine if the hand is Two Pairs
        
        ArrayList<Integer> pairs = pairCheck(hand);
        
        //there's only two pairs of rank values, 
        //and the first and second occurrences do not overlap
        if (pairs.size() == 2 && pairs.get(1) - pairs.get(0) > 1){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean threeOfAKind(ArrayList<Card> hand){
        // Determine if the hand is Three of a Kind
        
        ArrayList<Integer> pairs = pairCheck(hand);
        
        //there are two pairs of rank values, 
        //and the first and second occurrences do overlap
        if (pairs.size() == 2 && pairs.get(1) - pairs.get(0) == 1){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean fourOfAKind(ArrayList<Card> hand){
        // Determine if the hand is Four of a Kind
        
        ArrayList<Integer> pairs = pairCheck(hand);
        
        //there are three pairs of rank values, 
        //and the three occurrences all overlap

        if (pairs.size() == 3 && pairs.get(2) - pairs.get(0) == 2){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean straight(ArrayList<Card> hand){
        // Determine if the hand is Straight
        
        ArrayList<Integer> pairs = pairCheck(hand);
        
        //A Straight hand doesn't have paired rank values
        if (pairs.size() != 0) {
            return false;
        }
        
        //It can have a low Ace or a high Ace
        else if(hand.get(hand.size() - 1).getRank() - hand.get(0).getRank() == 4 || 
                hand.get(hand.size() - 1).getRank() - hand.get(1).getRank() == 3 &&
                hand.get(1).getRank() - hand.get(0).getRank() == 9){
            return true;
        }
        return false;
    }
    
    private boolean fullHouse(ArrayList<Card> hand){
        // Determine if the hand is Full House
        
        ArrayList<Integer> pairs = pairCheck(hand);
        
        //there are three pairs of rank values,
        //and the first&second and fourth&fifth rank values are two equal pairs
        if (pairs.size() == 3 && pairs.get(0) == 0 && pairs.get(2) == 3){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean straightFlush(ArrayList<Card> hand){
        // Determine if the hand is Straight Flush
        
        return flush(hand) && straight(hand);
    }
    
    private boolean royalFlush(ArrayList<Card> hand){
        // Determine if the hand is Royal Flush
        
        return straightFlush(hand) && hand.get(0).getRank() == 1 
            && hand.get(hand.size() - 1).getRank() == 13;
    }

    private double decideOdds(String result){
        // Find payout according to evaluation result
        
        switch(result){
            case "One Pair" : return 1;
            case "Two Pairs" : return 2;
            case "Three of a Kind" : return 3;
            case "Straight" : return 4;
            case "Flush" : return 5;
            case "Full House" : return 6;
            case "Four of a Kind" : return 25;
            case "Straight Flush" : return 50;
            case "Royal Flush" : return 250;
            default : return 0;
        }
    }
    
    private void showResult(double originalBankroll, String result, double odds){ 
        
        // Show game result to the user

        System.out.println("\n \n#########################");
        System.out.println("Moment of truth!");
        System.out.println("#########################\n \n");
        
        
        System.out.println("Your original bankroll is " + originalBankroll + ". ");
        
        
        // Print hand and evaluation result
        p.printHand();
        System.out.println("Which is 【"+ result + "】.");
        
        
        System.out.println("The payout is "+ odds + ", and your bet is " + p.getBet() + ". ");
        System.out.println("In this round, you won " + odds * p.getBet() + " tokens.");
        System.out.print("Now your bankroll is: "+ p.getBankroll() + ". ");
        if (odds > 1){
            System.out.println("Congratulations!");
        }

    }
    
}
