package Poker_Game;

import java.util.Arrays;
import java.util.Comparator;

public class Hands {

	public String[] hands;
	public int ace, two , three, four, five, six, seven, eight, nine, ten, jack, queen, king;
	public int hearts, diamonds, spade, clubs;
	private Integer[] handRank;


	// Constructor
	public Hands(){
		hands = new String[5];
		ace = two = three = four = five = six = seven = eight = nine = ten = jack = queen = king = 0;
		hearts = diamonds = spade = clubs = 0;
		handRank = new Integer[5];
		for(int i = 0 ; i < 5; i++){
			handRank[i] = 0;
		}
	}

	/*
	 * Assigns each hand elements 
	 */
	public void setHands (Hands hands){
		this.hands[0] = hands.hands[0];
		this.hands[1] = hands.hands[1];
		this.hands[2] = hands.hands[2];
		this.hands[3] = hands.hands[3];
		this.hands[4] = hands.hands[4];	
		findAndSetRankHands();
		setHandsInOrder();
	}

	/*
	 * Finds the rank for each hands and sets it to the hand rank array
	 */
	private void findAndSetRankHands() {
		String cardName;
		int counter = 0;
		for(int i = 0 ; i < this.handRank.length; i++){
			cardName = this.hands[i];
			if(cardName.contains("Ace")){ this.handRank[counter] = 1; counter++;}
			else if(cardName.contains("King")){ this.handRank[counter] = 2; counter++;}
			else if(cardName.contains("Queen")){ this.handRank[counter] = 3; counter++;}
			else if(cardName.contains("Jack")){ this.handRank[counter] = 4; counter++;}
			else if(cardName.contains("Ten")){ this.handRank[counter] = 5; counter++;}
			else if(cardName.contains("Nine")){ this.handRank[counter] = 6; counter++;}
			else if(cardName.contains("Eight")){ this.handRank[counter] = 7; counter++;}
			else if(cardName.contains("Seven")){ this.handRank[counter] = 8; counter++;}
			else if(cardName.contains("Six")){ this.handRank[counter] = 9; counter++;}
			else if(cardName.contains("Five")){ this.handRank[counter] = 10; counter++;}
			else if(cardName.contains("Four")){ this.handRank[counter] = 11; counter++;}
			else if(cardName.contains("Three")){ this.handRank[counter] = 12; counter++;}
			else if(cardName.contains("Two")){ this.handRank[counter] = 13; counter++;}
		}
	}

	/*
	 * Set hands in order of ranks
	 * Sorts using 
	 */
	private void setHandsInOrder(){
		Integer [] sortedRank = new Integer[5];
		String[] tempHand = new String[5];
		int[] tempRankHand = new int[5];
		for(int i = 0 ; i< this.handRank.length; i++ ){
			sortedRank[i] = this.handRank[i];
			tempHand[i] = this.hands[i];
			tempRankHand[i]= this.handRank[i];
		}


		Arrays.sort(sortedRank, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer x, Integer y)
			{
				return x - y;
			}
		});	

		for(int i = 0; i <sortedRank.length; i++){
			for(int j = 0; j < this.handRank.length; j++){
				if(sortedRank[i].equals(tempRankHand[j])){
					this.hands[i] = tempHand[j];
					this.handRank[i] = tempRankHand[j];
				}
			}
		}
	}

	/*
	 * Prints an array of Integers
	 */
	public void printArray(Integer[] array){
		for(int i = 0;i <array.length; i++){
			System.out.print(array[i]+",");
		}
		System.out.println();
	}

	/*
	 * Prints out all the elements of a hand
	 */
	public void printHands (){
		for(int i = 0 ; i <5; i++){
			System.out.print(" "+hands[i]);
		}
		System.out.println();
		System.out.println();
	}

	/*
	 * Find out the kind of hand each element has.
	 */
	public void findHandRank(){
		royalFlush();
		straightFlush();
		fourOfAKind();
		threeOfAKind();
		fullHouse();
		flush();
		straight();
		threeOfAKind();
		twoPair();
		pair();
		highCard();		
	}

	/* RANK # 1
	 * Royal Flush
	 */
	private boolean royalFlush() {
		boolean result = false;
		// Check for royal flush
		if (((spade == 5) || (hearts == 5) ||(clubs == 5) || (diamonds == 5)) && 
				((ace == 1) && (king == 1) && (queen == 1) && (jack ==1) && (ten == 1))){
			result = true;
		}
		return result;
	}

	/* RANK # 2
	 * Straight Flush
	 */
	private boolean straightFlush() {
		boolean result = false;

		// Check for Straight flush
		if (((spade == 5) || (hearts == 5) ||(clubs == 5) || (diamonds == 5)) && straight()){
			result = true;
		}
		return result;
	}

	/* RANK # 3
	 * Four of a Kind
	 */
	private boolean fourOfAKind() {
		boolean result = false;

		// Check for Four of a kind
		if ( ace == 4 || two == 4 || three == 4 || four == 4 || five == 4 || six == 4 || seven == 4 
				|| eight == 4 || nine == 4 || ten == 4 || jack == 4 || queen == 4 || king == 4){
			result = true;
		}
		return result;
	}

	/* RANK # 4
	 * Full House
	 */
	private boolean fullHouse() {
		boolean result = false;

		// Check for Full house
		if(pair() && threeOfAKind()){
			result = true;
		}
		return result;
	}

	/* RANK # 5
	 * Flush
	 */
	private boolean flush() {
		boolean result = false;

		// Check for Flush
		if(hearts == 5 || diamonds == 5 || clubs == 5 || spade == 5){
			result = true;
		}
		return result;
	}

	/* RANK # 6
	 * Royal Straight
	 */
	private boolean straight() {
		boolean result = false;

		// Check for Straight
		if( ace == 1 && two == 1 && three == 1 && four ==1 && five ==1){
			result = true;
		}
		else if (two == 1 && three == 1 && four ==1 && five == 1 && six == 1){
			result = true;
		}
		else if (three == 1 && four ==1 && five == 1 && six == 1 && seven == 1){
			result = true;
		}
		else if (four ==1 && five == 1 && six == 1 && seven == 1 && eight == 1){
			result = true;
		}
		else if (five == 1 && six == 1 && seven == 1 && eight == 1 && nine == 1){
			result = true;
		}
		else if (six == 1 && seven == 1 && eight == 1 && nine == 1 && ten == 1){
			result = true;
		}		
		return result;
	}

	/* RANK # 7
	 * Three of a Kind
	 */
	private boolean threeOfAKind() {
		boolean result = false;

		// Check for Three of a kind
		if ( ace == 3 || two == 3 || three == 3 || four == 3 || five == 3 || six == 3 || seven == 3 
				|| eight == 3 || nine == 3 || ten == 3 || jack == 3 || queen == 3 || king == 3){
			result = true;
		}
		return result;
	}

	/* RANK # 8
	 * Two Pair
	 */
	private boolean twoPair() {
		boolean result = false;

		// Check for Two Pair
		return result;
	}

	/* RANK # 9
	 * Pair
	 */
	private boolean pair() {
		boolean result = false;

		// Check for Pair
		if ( ace == 2 || two == 2 || three == 2 || four == 2 || five == 2 || six == 2 || seven == 2 
				|| eight == 2 || nine == 2 || ten == 2 || jack == 2 || queen == 2 || king == 2){
			result = true;
		}
		return result;
	}

	/* RANK # 10
	 * High Card
	 */
	private boolean highCard() {
		boolean result = false;

		// Check for High Card
		if(!royalFlush() && !straightFlush() &&	!fourOfAKind() && !threeOfAKind() && !fullHouse() && !flush()
				&& !straight() && !threeOfAKind() && !twoPair() && !pair()) {
			result = true;
		}
		return result;
	}	

	/*
	 * Gets the count for the rank of each hand 
	 */
	public void getCardsValueCount(){
		ace = two = three = four = five = six = seven = eight = nine = ten = jack = queen = king = 0;

		for(int i = 0; i < this.hands.length; i++){
			if(this.hands[i].contains("Ace")){
				ace++;
			}
			else if (this.hands[i].contains("Two")){
				two++;
			}
			else if (this.hands[i].contains("Three")){
				three++;
			}
			else if (this.hands[i].contains("Four")){
				four++;
			}
			else if (this.hands[i].contains("Five")){
				five++;
			}
			else if (this.hands[i].contains("Six")){
				six++;
			}
			else if (this.hands[i].contains("Seven")){
				seven++;
			}
			else if (this.hands[i].contains("Eight")){
				eight++;
			}
			else if (this.hands[i].contains("Nine")){
				nine++;
			}
			else if (this.hands[i].contains("Ten")){
				ten++;
			}
			else if (this.hands[i].contains("Jack")){
				jack++;
			}
			else if (this.hands[i].contains("Queen")){
				queen++;
			}
			else if (this.hands[i].contains("King")){
				king++;
			}			
		}
	}

	/*
	 * Gets the count for the suit of each hand 
	 */
	public void getSuitCount(){
		hearts = diamonds = spade = clubs = 0;

		for(int i =0; i < this.hands.length; i++){
			if(this.hands[i].contains("Hearts")) {
				hearts++;
			}
			else if(this.hands[i].contains("Diamonds")){
				diamonds++;
			}
			else if(this.hands[i].contains("Spades")) {
				spade++;
			}
			else if(this.hands[i].contains("Clubs")) {
				clubs++;
			}
		}
	}
}

