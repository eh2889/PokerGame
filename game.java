import java.util.*;

public class Game {
	
	private Player p;
	private Deck cards;
    private Scanner input;
    
	
	
	public Game(String[] testHand){
		// This constructor is to help test code.
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
        p = new Player();
        for (int i = 0; i < 5; i++) {
            p.addCard(Card.cardFromString(testHand[i]));
        }
		
		
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		p = new Player();
        cards = new Deck();
        cards.shuffle();
        input = new Scanner(System.in);
        
		
	}
	
	public void play(){
		// this method should play the game	
		String playAgain = "yes";
        
        while (playAgain.equalsIgnoreCase("yes")) {
            if (p.getSize() < 5) {
                for (int i = 0; i <5; i++) {
                    p.addCard(cards.deal());
                }
            }
            
            //sets up the prompts for the user
            System.out.println("Your bankroll is: " + p.getBankroll());
            System.out.println("Enter a bet (1-5): ");
            p.bets(input.nextDouble());
            System.out.println("New Bankroll: " + p.getBankroll());
            p.sort();
            System.out.println("Here is your hand: ");
            System.out.println(p.getCard(0).toString() + ", " +p.getCard(1).toString() + ", " + p.getCard(2).toString() + ", " + p.getCard(3).toString() + ", " + p.getCard(4).toString());
            
           
            System.out.println("How many cards do you wish to replace? ");
            int numReplace = input.nextInt();
            Card[] replace = new Card[numReplace];
            if (numReplace > 0) {
                for (int i = 0; i < numReplace; i++) {
                    System.out.println("What is the card that you wish to replace (put 0 for first card, 1 for second, and so on): ");
                    int cardPlace = input.nextInt();
                    replace[i] = p.getHand().get(cardPlace);
                }
                for (Card c : replace) {
                    if (p.getHand().contains(c)) {
                        p.getHand().remove(c);
                    }
                }
                
                for (int i = 0; i < numReplace; i++) {
                    p.addCard(cards.deal());
                }
                p.sort();
                System.out.println("Here is your new hand: ");
                System.out.println(p.getCard(0).toString() + ", " +p.getCard(1).toString() + ", " + p.getCard(2).toString() + ", " + p.getCard(3).toString() + ", " + p.getCard(4).toString());
                
            }
            
            System.out.println("Here is the result of your hand: " + checkHand(p.getHand()));
            System.out.println("Your new bankroll is: " + p.getBankroll());
            }
        System.out.println("Play Again? yes or no");
        playAgain = input.next();
        if(playAgain.equalsIgnoreCase("yes")) {
            p.clear();
        }

        
        
        
            
                
            
        }
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		if (p.pair()) {
            p.winnings(1);
            return "Pair";
        }
        if (p.twoPairs()) {
            p.winnings(2);
            return "Two Pair";
        }
        if (p.threeOfAKind()) {
            p.winnings(3);
            return "Three of a kind";
        }
        if (p.straight()) {
            p.winnings(4);
            return "Straight";
        }
        if (p.flush()) {
            p.winnings(5);
            return "Flush";
        }
        if (p.fullHouse()) {
            p.winnings(6);
            return "Full House";
        }
        if (p.fourOfAKind()) {
            p.winnings(25);
            return "Four of a kind";
        }
        if (p.straightFlush()) {
            p.winnings(50);
            return "Straight Flush";
        }
        if (p.royalFlush()) {
            p.winnings(250);
            return "Royal Flush";
        }
        return "NO PAIR :(";
	}
	

}
