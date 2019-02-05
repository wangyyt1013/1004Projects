# Overall design
  The four classes (Card, Deck, Game and Player) work together to run the 
  Video Poker game. The Card class implements the Comparable interface and
  can therefore be ranked and compared to each other according to their suit
  and rank, just like we do with actual poker cards. The Deck class is made up
  of 52 Card objects that mimic a set of poker cards with 4 suits, each having
  13 ranks (Ace, 2, ..., 10, Jack, Queen, King), and the deck of cards can be 
  shuffled and dealed. The Player class simulates a human player with a certain
  number of cards in their hand, and the hand of cards can be added/removed. The
  human player also starts with a number of bankroll and a bet they makes for 
  each round, and the bankroll value will change after every round depending on
  the result of their bet. Finally, the Game class contains the basic rules for
  the Video Poker: it contains methods that actually interact with the user,
  including printing out the hand of cards, allowing the user to replace some cards
  in the hand, evaluating the hand of cards and showing the user the final result.
  
# Instructions for use
  To start the game, create a new Game object with no argument for the constructor.
  Call the play method to start the game, and then act according to the printed 
  instructions to continue playing the game. Note that the readers are allowed
  to input their own initial bankroll, and they can choose a bet of 1 to 5 tokens 
  for each round. The bet will be subtracted from the bankroll when it is made, and
  the following earnings the user may gain is determined by the product of the 
  payout of their hand and their bet. The player's goal is to increase their 
  bankroll as much as they can, but they cannot bet more tokens than the amount 
  of tokens they have for each round, and they are only allowed to redraw at most
  5 poker cards after they are shown their initial hand of cards. 