import java.util.ArrayList;

public class Player {
	
		
	private ArrayList<Card> hand; //the player's cards
	private double bankroll;
    private double bet;

		
	public Player(){		
	    //create a player here
	    hand = new ArrayList<Card>(5);
        bankroll = 1000;
	}

	public void addCard(Card c){
	    //add the card c to the player's hand
	    hand.add(c);

	}

	public void removeCard(Card c){
	    //remove the card c from the player's hand
	    hand.remove(c);
        }
		
        public void bets(double amt){
            //player makes a bet
            if (amt <= 5 && amt >= 1) {
                bet = amt;
                bankroll = bankroll-bet;
            }
            else {
                
                
            }
           
        }

        public void winnings(double odds){
            //adjust bankroll if player wins
            bankroll += (odds*bet);
        }

        public double getBankroll(){
            //return current balance of bankroll
            return bankroll;
        }
    
    //return hand
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    //sorts hand by rank and suit
    public void sort() {
        for (int i = 0; i<5; i++) {
            for (int j = i+1; j<5; j++) {
                if (hand.get(j).getRank() < hand.get(i).getRank()) {
                    Card temporary = new Card(hand.get(j).getSuit(),hand.get(j).getRank());
                    hand.get(j).createCard(hand.get(i).getSuit(), hand.get(i).getRank());
                    hand.get(i).createCard(temporary.getSuit(), temporary.getRank());
                }
            }
        }
    }
    
    //return size of hand
    public int getSize() {
        return hand.size();
    }
    
    //clears the hand
    public void clear() {
        for (int i = 0; i<5; i++) {
            hand.remove(0);
        }
    }
    
    //return a card from a certain position in a hand
    public Card getCard(int pos) {
        return hand.get(pos);
    }
    
    //the rest of the methods test the different possible outcomes of the player's hands
    public boolean pair() {
        int pair = 0;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i-1).getRank() == hand.get(i).getRank()) {
                pair++;
            }
        }
        if (pair == 1) {
            return true;
        }
        else {
            return false;
        }
    }
        
    
    public boolean twoPairs() {
        int pair = 0;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i-1).getRank() == hand.get(i).getRank()) {
                pair++;
            }
        }
        if (pair == 2) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean threeOfAKind() {
        if (hand.get(0).getRank() == hand.get(2).getRank()) {
            return true;
        }
        else if (hand.get(1).getRank() == hand.get(3).getRank()) {
            return true;
        }
        else if (hand.get(2).getRank() == hand.get(4).getRank()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean straight() {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i-1).getRank() != (hand.get(i).getRank() - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean flush() {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(0).getSuit() != hand.get(i).getSuit()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean fullHouse() {
        int pair = 0;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i-1).getRank() == hand.get(i).getRank()) {
                pair++;
            }
        }
        if (pair == 3) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public boolean fourOfAKind() {
        if (hand.get(0).getRank() == hand.get(3).getRank() || hand.get(1).getRank() == hand.get(4).getRank()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean straightFlush() {
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(0).getSuit() != hand.get(i).getSuit()) {
                return false;
            }
        }
        for (int j = 1; j < hand.size(); j++) {
            if (hand.get(j-1).getRank() != (hand.get(j).getRank()-1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean royalFlush() {
        if (hand.get(0).getRank() == 1 && hand.get(1).getRank() == 10 && hand.get(2).getRank() == 11 && hand.get(3).getRank() == 12 && hand.get(4).getRank() == 13) {
            return true;
        }
        return false;
    }
    
    

}


