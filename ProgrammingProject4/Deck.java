/* 
 * This class simulates a deck of 52 poker cards.
 * 
 * @author: Yuanyuting Wang (yw3241)
 * @date: 2018.11.02
 */

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck

	public Deck(){
		// make a 52 card deck here
		
		cards = new Card[52];
        for (int i = 0; i < cards.length; i++){
            cards[i]=new Card(i / 13 + 1, i % 13 + 1);
        top = 0;
        }
	}
	
	public void shuffle(){
		// shuffle the deck here by swapping every card with a randomly
		// selected card from the rest of the deck
		
        for (int i = 0; i < cards.length; i++){
            Card temp = new Card(cards[i].getSuit(), cards[i].getRank());
            int swapNumber = (int) (Math.random()*52);
            cards[i] = cards[swapNumber];
            cards[swapNumber] = temp;
        }
	}
	
	public Card deal(){
		// deal the top card in the deck
		
		Card topCard = new Card(cards[top].getSuit(),
                                cards[top].getRank());
        top++;
        
        //after reaching the end of the deck, shuffle
        if (top == 52){
            shuffle();
            top = 0;
        }
        
        return topCard;
	}

}
