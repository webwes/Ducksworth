import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game extends Deck {
	
	public boolean stilPlaying = true;
	
	public boolean[][] cardOnFieldbool = {{false, false, false, false},{ false, false, false, false}};
	//0 is player one; 1 is player 2
	
	public Card[][] cardOnFieldcard = {{new Card(0,0,false,'0'), new Card(0,0,false,'0'), new Card(0,0,false,'0'),new Card(0,0,false,'0')},
										{new Card(0,0,false,'0'), new Card(0,0,false,'0'), new Card(0,0,false,'0'),new Card(0,0,false,'0')}};
	//manages who played which card
	//same as bool
	public boolean playerTurn = true;
	//if its the first players turn the turn is true, if its the second its false

	public ArrayList<Card> cards = generateDeck();
	public ArrayList<Card> inPlay = new ArrayList<Card>();
	public ArrayList<Card> inPlay2 = new ArrayList<Card>();
	public Integer turnCount = 0;
	public Integer s = 0;
	public int x = 4;
	
	public Card selectedCard;
	
	public int player1Health = 5;
	public int player2Health = 5;
	
	public Game(){
		shuffle();
		getOpeningHand();
	}
	
	//this returns your opening hand  by removing the first 5 cards from the deck and adding them to the hand
	public void getOpeningHand(){
		ArrayList<Card> pHand = new ArrayList<Card>(5);
		ArrayList<Card> pHand2 = new ArrayList<Card>(5);
		
		for(int i = 1; i < 5; i++){
			pHand.add(cards.get(i));
			cards.remove(i);
		}
		
		inPlay = pHand;
		
		
		for(int i = 1; i < 5; i++){
			pHand2.add(cards.get(i));
			cards.remove(i);
		}
		
		inPlay2 = pHand2;
		
		
		
	}
	//returns the cards on the board in an arraylist
	public ArrayList<Card> getInPlay(){
		System.out.println(inPlay);
		
		return inPlay;
	}
	public ArrayList<Card> getInPlay2(){
		
		System.out.println(inPlay2);
		return inPlay2;
	}
	//Draws the current play board and prints it
	public void DrawBoard(){
		
		//draw the first person's board
		for(int i =0;i<4;i++){
			
			System.out.print(cardOnFieldcard[0][i].toString() + " ");
		}
		//separate the two
		System.out.println();
		
		//draw the second person's board
		for(int i =0;i<4;i++){
			
			System.out.print(cardOnFieldcard[1][i].toString() + " ");
		}
		
		System.out.println();
	}
	
	//When a number is chosen between 3 to 9, it is played on the board from left to right when available
	public void playFighter(Card hold){
		
		if(playerTurn){
			for(int i = 0; i < 4; i++ ){
				if(!cardOnFieldbool[0][i]){
					cardOnFieldcard[0][i] = hold;
					for(int j = 0; j<inPlay.size(); j++){
						if(inPlay.get(j).equals(hold)){
							inPlay.remove(j);
							j=inPlay.size();
						}
					}
					cardOnFieldbool[0][i] = true;
					
					break;
				}
				
			}
			
		}else{
			for(int i = 0; i < 4; i++ ){
				if(!cardOnFieldbool[1][i]){
					cardOnFieldcard[1][i] = hold;
					for(int j = 0; j<inPlay2.size(); j++){
						if(inPlay2.get(j).equals(hold)){
							inPlay2.remove(j);
							j=inPlay2.size();
						}
					}
					cardOnFieldbool[1][i] = true;
					
					break;
				}
				
			}
			
		}
	
		
	}
	
	//uses human input to choose which card to play from hand returning one card
	public Card chooseCard(){
		
		
		System.out.println("input command:");
		
		
		Scanner inputFromUser = new Scanner(System.in);
		String str = inputFromUser.nextLine();
		
		if((!str.equals("end"))&&(!str.equals("play"))&&(!str.equals("fight"))) System.out.println("incorrect command"); System.out.println();
				
		selectedCard = new Card(0,0,false,'?');
		
		if(str.equals("fight")){
			fight();
		}
		
		
		if(str.equals("end")){
			playerTurn = !playerTurn;
			if(playerTurn) System.out.println("player's 1's turn");
			if(!playerTurn) System.out.println("player's 2's turn");
		}
		
		if(str.equals("play")){
			System.out.println("play what?");
			
			if(playerTurn){
				try{
					selectedCard = inPlay.get(inputFromUser.nextInt()-1);
				}catch(IndexOutOfBoundsException|InputMismatchException e){
					System.out.println("get it right.");
					
				}
				s = inPlay.lastIndexOf(selectedCard);
			}else{
				try{
					selectedCard = inPlay2.get(inputFromUser.nextInt()-1);
				}catch(IndexOutOfBoundsException|InputMismatchException e){
					System.out.println("get it right.");
					
				}
				s = inPlay2.lastIndexOf(selectedCard);
			
			}
		}
		
		
		return selectedCard;
		
	}
	
	
	
	public void fight(){
		
		System.out.println("With what?");
		
		Scanner attacker = new Scanner(System.in);
		
		Card atkCard = new Card();
		
		int atk = attacker.nextInt();
		
		if(playerTurn){
			 atkCard = cardOnFieldcard[0][atk];
		}
		if(!playerTurn){
			atkCard = cardOnFieldcard[1][atk];
		}
		
		
		System.out.println("What are you attacking?");
		
		Scanner target = new Scanner(System.in);
		
		String holder = target.nextLine();
		
		if(holder.equals("player")){
			if(playerTurn){
				if(!cardOnFieldbool[0][0]&&!cardOnFieldbool[0][1]&&!cardOnFieldbool[0][2]&&!cardOnFieldbool[0][3]){
					player2Health--;
				}
			}
			if(!playerTurn){
				if(!cardOnFieldbool[0][0]&&!cardOnFieldbool[0][1]&&!cardOnFieldbool[0][2]&&!cardOnFieldbool[0][3]){
					player1Health--;
				}
			}
			System.out.println("Player 1 HP: " + player1Health);
			System.out.println("Player 2 HP: " + player2Health);
			playerTurn = !playerTurn;
			System.out.println("Turn Switch");
		}else{
		
		Integer def = Integer.parseInt(holder);
		
		Card defCard = new Card(0,0,false,'?');
		
		
		
		if(playerTurn){
			 defCard = cardOnFieldcard[1][def];
		}
		if(!playerTurn){
			defCard = cardOnFieldcard[0][def];
		}
		
		System.out.println("Fighting...");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int x =0;
		if(playerTurn) x=1;
		
		
		if(defCard.getCardValue()>atkCard.getCardValue()){
			System.out.println("rip " +cardOnFieldcard[x][atk]);
			cardOnFieldcard[x][atk]= new Card(0,0,false,'?');
			cardOnFieldbool[x][atk]=false;
		}
		if(defCard.getCardValue()<atkCard.getCardValue()){
			System.out.println("rip " + cardOnFieldcard[x][def]);
			cardOnFieldcard[x][def]= new Card(0,0,false,'?');
			cardOnFieldbool[x][def]=false;
		}
		if(defCard.getCardValue()==atkCard.getCardValue()){
			System.out.print("rip " + cardOnFieldcard[x][atk]+" ");
			System.out.println(cardOnFieldcard[x][def]);
			cardOnFieldcard[x][atk]= new Card(0,0,false,'?');
			cardOnFieldcard[x][def]= new Card(0,0,false,'?');
			cardOnFieldbool[x][def]=false;
			cardOnFieldbool[x][atk]=false;
		}
		DrawBoard();
		getInPlay();
		System.out.println();
		System.out.println();
		System.out.println();
		}
	}
	
	//Return the top card of the deck, then remove that card from the deck
	public void drawCard(boolean hike){
		
		if(hike){
			Card hold = cards.get(0);
			inPlay.add(hold);
			cards.remove(0);
		}
		if(!hike){
			Card hold = cards.get(0);
			inPlay2.add(hold);
			cards.remove(0);
		}
		
	}
	
	public boolean getPlayerTurn(){
		return playerTurn;
	}
	
	public void specialtyCard(Card hold, int s) {
		if(hold.getFaceValue() == 'k'){
			
			if(!playerTurn){
				for(int i = 0; i < inPlay.size(); i++){
					if(inPlay.get(i).getFaceValue() == 'k'){
					inPlay.remove(i);
					
					}
				}
				 for(int i =0;i<4;i++){
					 cardOnFieldbool[0][i]=false;
				 }
				 for(int i =0;i<4;i++){
					 cardOnFieldcard[0][i] = new Card(0,0,false,'0');
				 }
				
			}else{
				for(int i = 0; i < inPlay.size(); i++){
					if(inPlay.get(i).getFaceValue() == 'k'){
					inPlay.remove(i);
					}
				}
				 for(int i =0;i<4;i++){
					 cardOnFieldbool[1][i]=false;
				 }
				
				 for(int i =0;i<4;i++){
					 cardOnFieldcard[1][i] = new Card(0,0,false,'0');
				 }
			}
		}
		
		if(hold.getFaceValue()== 'q'){
			if(playerTurn){
				for(int i = 0; i < 4; i++ ){
					if(!cardOnFieldbool[0][i]){
						cardOnFieldcard[0][i] = new Card(0,0,true, 'q');
						for(int j = 0; j<inPlay.size(); j++){
							if(inPlay.get(j).equals(hold)){
								inPlay.remove(j);
								j=inPlay.size();
							}
						}
						cardOnFieldbool[0][i] = true;
						
						break;
						}
					}
				}
			}
		if(hold.getFaceValue()== 'j'){
			drawCard(true);
			drawCard(true);
			inPlay.remove(s);
			}
		if(hold.getFaceValue()== 'a'){
			if(playerTurn){
				
				 for(int i =0;i<4;i++){
					 cardOnFieldbool[0][i]=false;
				 }
				 for(int i =0;i<4;i++){
					 cardOnFieldcard[0][i] = new Card(0,0,false,'0');
				 }
				
				 
				cards = generateDeck();
				inPlay = new ArrayList<Card>();
				getOpeningHand();
				for(int i = x; i<=4; i++){				
					inPlay.remove(0);
				}
				x--;
				}
			
			}
		
		
		if(!playerTurn){
			System.out.println("player 1's turn");
			drawCard(!playerTurn);
		}
		if(playerTurn){
			System.out.println("player 2's turn");
			drawCard(playerTurn);
		}
			
			playerTurn=!playerTurn;
		}
	
		
	
	public void phase1(){
		
		if(stilPlaying){
		if(player1Health == 0){
			System.out.println("p1win");
			stilPlaying = !stilPlaying;
		}
		if(player2Health == 0){
			System.out.println("p2win");
			stilPlaying = !stilPlaying;
		}
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println();
		getInPlay();
		System.out.println();
		getHealth();
		System.out.println();
		Card hold = chooseCard();
		if(hold.getFaceValue() == 'j'||hold.getFaceValue() == 'q'||hold.getFaceValue() == 'k'||hold.getFaceValue() == 'a'){
			specialtyCard(hold,s);
			
		}else{
			playFighter(hold);
			
		}
		}
	}
	public ArrayList<Card> shuffle(){
		Collections.shuffle(cards);
		return cards;
	 }	
	public void getHealth(){
		System.out.println("Player 1's HP: " + player1Health);
		System.out.println("Player 2's HP: " + player2Health);
	}
	public boolean stillPlaying(){
		if(stilPlaying) System.out.println("StillPlaying");
		if(!stilPlaying) System.out.println("DonePlaying");
		return stilPlaying;
		
	}
}


