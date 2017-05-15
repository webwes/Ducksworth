

public class Card {
	
	//introducing the variables required for a Card
	private int cardValue;
	private int deckNumber;
	private boolean isFace;
	private char faceValue;
	
	//these are playing cards, so its either a number or k,q,j,a 

	
	//Default constructor. If there is some sort of glitch resulting in a bad card being made, this is it
	public Card(){
		cardValue = -1;
		deckNumber = -1;
		isFace = false;
		faceValue = '?';
	}
	
	
	//NonDefault. takes in variables throws them back out to be saved
	public Card(int cardValue,int deckNumber, boolean isFace, char faceValue){
		this.cardValue = cardValue;
		this.deckNumber = deckNumber;
		this.isFace = isFace;
		this.faceValue = faceValue;
	}
	
	//getters
	public int getCardValue(){
		return cardValue;
	}
	
	public int getDeckNumber(){
		return deckNumber;
	}
	
	public boolean getIsFace(){
		return isFace;
	}
	
	public char getFaceValue(){
		return faceValue;
	}
	
	//this makes it so deck isnt a butt and lets me return the cards in string
	 @Override
	   public String toString() {
		 if(this.getFaceValue()=='?'){
	        return (this.getCardValue()+ "");
	              
		 }
		 else{
			 return   "" + this.getFaceValue();
		 }
	   }
}


