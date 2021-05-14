import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int top; //the index of the top of the deck
	
    //creates a 52 card deck
	public Deck(){
		//make a 52 card deck here
		cards = new Card[52];
        int i = 0;
        
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1;rank <= 13; rank++) {
                cards[i] = new Card(suit,rank);
                i++;
            }
        }
	}
	
	public void shuffle(){
		//shuffle the deck here
		Random rand = new Random();
		for (int i = 0; i<52; i++) {
            int random = i + rand.nextInt(52-i);
            
            Card temporary = cards[random];
            cards[random] = cards[i];
            cards[i] = temporary;
            
        }
	}
	
	public Card deal(){
		//deal the top card in the deck
		if (top < 53) {
            top++;
            return cards[top-1];
        }
        else {
            System.out.println("No cards left");
            return cards[top-1];
        }
	}
	

}
