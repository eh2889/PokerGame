public class Card implements Comparable<Card>{
	
	private int suit; //use integers 1-4 to encode the suit
	private int rank; //use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		suit = s;
        rank = r;
        
	}
    
    // return card rank
    public int getRank() {
        return rank;
    }
	
    //return card suit
    public int getSuit() {
        return suit;
    }
    
    //Compare two cards by rank and suit
	public int compareTo(Card c){
		//use this method to compare cards so they 
		//may be easily sorted
		int compare = 0;
        
        if (this.rank < c.rank) {
            compare = -1;
        }
        
        if (this.rank == c.rank) {
            if (this.suit < c.suit) {
                compare = -1;
            }
            if (this.suit > c.suit) {
                compare = 1;
            }
        }
        
        if (this.rank > c.rank) {
            compare = 1;
        }
        
        return compare;

	}
	
    //convert numerical rank and suit into a string
	public String toString(){
		//use this method to easily print a Card object
		String card = "";
        
        switch(rank) {
            case 1:
                card += "Ace of ";
                break;
            case 2:
                card += "2 of ";
                break;
            case 3:
                card += "3 of ";
                break;
            case 4:
                card += "4 of ";
                break;
            case 5:
                card += "5 of ";
                break;
            case 6:
                card += "6 of ";
                break;
            case 7:
                card += "7 of ";
                break;
            case 8:
                card += "8 of ";
                break;
            case 9:
                card += "9 of ";
                break;
            case 10:
                card += "10 of ";
                break;
            case 11:
                card += "Jack of ";
                break;
            case 12:
                card += "Queen of ";
                break;
            case 13:
                card += "King of ";
                break;
        }
        switch(suit) {
            case 1:
                card += "clubs";
                break;
            case 2:
                card += "diamonds";
                break;
            case 3:
                card += "hearts";
                break;
            case 4:
                card += "spades";
                break;
                
                    
        }
        
        
        return card;
        
            
	}
    
    //sets rank and suit for a card
    public void createCard(int s, int r) {
        this.suit = s;
        this.rank = r;
    }
	//add some more methods here if needed
	
	//converts inputted strings into a card
	public static Card cardFromString(String str) {
        Card cardrep = new Card(0,0);
        int endSuit = 0;
        int endRank = 0;
        
        if (str.charAt(0) == 'c') {
            endSuit = 1;
        }
        if (str.charAt(0) == 'd') {
            endSuit = 2;
        }
        if (str.charAt(0) == 'h') {
            endSuit = 3;
        }
        if (str.charAt(0) == 's') {
            endSuit = 4;
        }
        if (str.charAt(1) == '1') {
            endRank = 1;
        }
        if (str.charAt(1) == '2') {
            endRank = 2;
        }
        if (str.charAt(1) == '3') {
            endRank = 3;
        }
        if (str.charAt(1) == '4') {
            endRank = 4;
        }
        if (str.charAt(1) == '5') {
            endRank = 5;
        }
        if (str.charAt(1) == '6') {
            endRank = 6;
        }
        if (str.charAt(1) == '7') {
            endRank = 7;
        }
        if (str.charAt(1) == '8') {
            endRank = 8;
        }
        if (str.charAt(1) == '9') {
            endRank = 9;
        }
        if (str.length() > 2){
            if (str.substring(1,3) == "10") {
            endRank = 10;
            }
            if (str.substring(1,3) == "11") {
            endRank = 11;
            }
            if (str.substring(1,3) == "12") {
            endRank = 12;
            }
            if (str.substring(1,3) == "13") {
            endRank = 13;
            }
        }
        cardrep.createCard(endSuit, endRank);
        return cardrep;
    }
}
