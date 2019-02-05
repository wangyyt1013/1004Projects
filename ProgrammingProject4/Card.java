/* 
 * This class simulates one single poker card.
 * 
 * @author: Yuanyuting Wang (yw3241)
 * @date: 2018.11.02
 */

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		
		suit = s;
        rank = r;
	}
		
	public String toString(){
		// use this method to easily print a Card object
		
        String suitString = "";
        String rankString = "";
        switch(this.suit){
            case 1 : suitString = "Diamonds";
                break;
            case 2 : suitString = "Clubs";
                break;
            case 3 : suitString = "Hearts";
                break;
            case 4 : suitString = "Spades";
                break;
            default : suitString = "gibber";
                break;
        }
        switch(this.rank){
            case 1 : rankString = "Ace";
                break;
            case 11 : rankString = "Jack";
                break;
            case 12 : rankString = "Queen";
                break;
            case 13 : rankString = "King";
                break;
            default : rankString = Integer.toString(rank);
                break;
        }
        return rankString + " of " + suitString;   
	}
	
    public int compareTo(Card c){
        // compare cards first based on rank, then based on suit
        
        if (rank < c.rank || (rank == c.rank) && (suit < c.suit)) {
            return -1;
        }
        else if (rank > c.rank || (rank == c.rank) && (suit > c.suit)){
            return 1;
        }
        else {
            return 0;
        }
    }
            
    public int getRank(){
        // access rank of a card
        
        return rank;
    }

    public int getSuit(){
        // access suit of a card
        
        return suit;
    }
}
