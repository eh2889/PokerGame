# PokerGame
Poker Game in Java

Implementation of popular casino game, video poker.

Card Class:
The card class works to give different functionalities for each card.
Each card is assigned a rank and a suit. The rank and suit are able to be accessed in other classes with the getRank() and getSuit methods.
The compareTo method compares different cards. The cards are first compared by the rank, and if the ranks are equal then it will compare the suit. Since the rank and suits are assigned by numbers at this point, it wasn't difficult to compare.
The toString method takes the rank and suit of the card and formats them into a string. (Ex: Ace of Spades, 4 of Hearts)
The cardFromString method is essentially the opposite of the toString method. It takes in a string with format (s1, s13, c4...) and converts the first letter into the suit number that corresponds and does the same for the rank.


Deck Class:
The deck class creates a deck of 52 cards, 13 of each suit. This is done in the Deck() method.
The shuffle method randomly shuffles these 52 cards. It does so by going through each element and assigning a random card until it has gone through all 52 slots. The random function causes a different shuffle to occur each time
The deal method deals cards from the top of the deck into the players hand.

Player Class:
The player class has a lot of different methods which help the game run. The player class is instantiated with a hand of 5 cards (an arraylist of 5) and a bankroll which I set to 1000 but could be set to any value.
The player class has methods addCard and removeCard which add and remove cards from the hands which is useful for when the player wishes to replace cards from his/her hand.
This class also contains different methods which work with the betting process. It has the method bets which takes in the amount the player wishes to bet as the parameter, stores that amount and subtracts it from the bankroll
The method winnings calculates how much the player wins given the odds of each different outcome and adds that to the bankroll
The getBankroll() method simply returns the bankroll which is useful for displaying the amount of money left to the user.
The getHand() method returns the hand that the player has currently
The sort method puts the cards in the hand into order based on rank and suit.
The getSize method returns the size of the hand. This is useful in the game class to tell if the hand has been dealt or if there are still 0 cards in the hand.
The clear method is used to clear the hand after a round has been played and the getCard method returns the card at a specific index in the hand.
The rest of the methods in this class test to see whether the hand has a pair, two pair, three of a kind, straight, flush, full house, four of a kind, straight flush, or royal flush. These methods are all boolean so they return a true or false depending on whether the hand contains that outcome.


Game Class:
The game class is what actually plays the poker game. Its first method is used so that a hand can be inputted for testing the game. 
It uses the inputted five cards to create a hand out of it which will then be used in the play method.
The second method Game() with no parameters uses a randomized deck and hand to play the game with no inputted cards. 
The play method is where the format of the game is created. It uses a variable called playAgain which is set to "yes" at the start. It runs a loop while that variable is still equal to "yes".
In that loop it will display the players bankroll and ask for how much the player wishes to bet. It will then show the player the hand and ask them if they want to replace any cards.
If the player chooses to replace cards the new hand will be shown and then the checkhand method is used to see if there are any favorable outcomes in the hand(aka anything other than no pair). If the hand has a pair or anything else it will add the winnings to the bankroll and ask if the player wishes to play again
If the player says "no" or anything other than "yes" the loop will stop and the game will terminate.
