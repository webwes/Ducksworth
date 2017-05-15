
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck extends Card {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	//Creates a non-random deck of playing cards for  the game
		public ArrayList<Card> generateDeck(){
			 
			for(int x = 0; x < 4; x++){
				for (int i = 0; i <= 6; i++) {
		         Card card = new Card(i+3, -1, false, '?'); //Instantiate a Card
		         cards.add(card); //Adding card to the Deck
		     }
			}
			for(int x = 0; x < 4; x++){
				Card card1 = new Card(-1, -1, true, 'j');
				Card card2 = new Card(-1, -1, true, 'q');
				Card card3 = new Card(-1, -1, true, 'k');
				Card card4 = new Card(-1, -1, true, 'a');
				cards.add(card1);
				cards.add(card2);
				cards.add(card3);
				cards.add(card4);
			}
			return cards;
		}
	
	//this makes it so deck isnt a butt and lets me return the cards in string
		 public void displayBaby(ArrayList<Card> tobedisp){
			 for(int i = 0; i<tobedisp.size();i++){
				System.out.println(tobedisp.get(i));
				
			 }
		 }
		 
		//this makes it so deck isnt a butt and lets me return the cards in string part 2
		 @Override
		   public String toString() {
			 String thicc = "";
			 
		        for(int i = 0; i < cards.size(); i++){
		        	thicc +=cards.get(i) + " ||| ";
		        	
		        }
		        return thicc;
		   }
		 
		 //returns the size of the deck
		 public int countCards(){
			 return cards.size();
		 }
		 
		 
		//this makes it so deck isnt a butt and lets me return the cards in string part 3
		 public String[] printMethod( ArrayList<Card> cards){
			 String[] hold = new String[cards.size()];
			 for(int i = 0; i <cards.size();i++){
				 Card test = cards.get(i);
				 hold[i]+=String.valueOf(test.getCardValue());
				 hold[i]+="_";
				 hold[i]+=String.valueOf(test.getDeckNumber());
				 hold[i]+="_";
				 hold[i]+=String.valueOf(test.getFaceValue());
				 hold[i]+="_";
				 hold[i]+=String.valueOf(test.getIsFace());
				 hold[i]=hold[i].substring(4);
			 }
			 return hold;
		 }
		 
		 //just returns the deck for some reason
		 public ArrayList<Card> getDeck(){
			 return cards;
		 }
		
}

