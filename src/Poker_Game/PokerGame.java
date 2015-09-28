package Poker_Game;
import java.util.Scanner;

public class PokerGame {

	public Players[] players;
	public int numberOfPlayers; 
	public Deck deckOfCards;

	// Constructor
	public PokerGame(int players) throws Exception{
		if (players < 2 || players > 5){
			throw new Exception("Invalid number of players, there can only be 2-4 players");
		}
		this.numberOfPlayers = players;
		this.deckOfCards = new Deck();
		this.players = new Players[this.numberOfPlayers];
		for(int i = 0 ; i < this.numberOfPlayers; i++){
			this.players[i] = new Players(i+1);
		}
	}	

	/*
	 * Set Hands Manually
	 */
	public void setHandsManually(int playerId, String card1,String card2,String card3,String card4,String card5){
		this.players[playerId].playerHand.hands[0]= card1;
		this.players[playerId].playerHand.hands[1]= card2;
		this.players[playerId].playerHand.hands[2]= card3;
		this.players[playerId].playerHand.hands[3]= card4;
		this.players[playerId].playerHand.hands[4]= card5;
	}

	/* Sets a hand of 5 for each players 
	 * 
	 */
	public void setAutoHandsForPlayers(){
		int totSwitch = 0;
		Hands[] allHands = new Hands[this.numberOfPlayers];

		for(int i = 0 ; i < this.numberOfPlayers; i++){
			allHands[i] = new Hands();
		}

		// Case for two players
		switch (this.numberOfPlayers){
		case 2:
			totSwitch = 1;
			break;
		case 3:
			totSwitch = 2;
			break;
		case 4:
			totSwitch = 3;
			break;
		case 5:
			totSwitch = 4;
			break;
		}

		int twist = 0;
		while (twist <= totSwitch){
			for(int i = 0 ; i < 5; i++){
				allHands[twist].hands[i] = this.deckOfCards.cards[(twist*5)+i];
			}	
			twist = twist + 1;
		}

		for(int i = 0; i < this.numberOfPlayers; i++){
			this.players[i].playerHand.setHands(allHands[i]);
		}

	}

	/* Prints out the hands for all the players 
	 * 
	 */
	public void printAllPlayerHands(){
		for(int i = 0 ; i < this.players.length; i++){
			players[i].printPlayerHand();		 
		}	
	}

	/* This method helps determine the score for each players
	 * 
	 */
	public void rank(){

	}

	/* MAIN Method 
	 * Start Simple Poker Game
	 */
	public static void main (String [] args) throws Exception{		
		Scanner a = new Scanner(System.in);		

		System.out.println("How many players are there (can only be between 2-5 payers)?");
		int players = a.nextInt();		
		while (players < 2 || players > 5){
			System.out.println("Invalid number of players, can only have between 2-5 players");
			players = a.nextInt();
		}

		PokerGame newGame = new PokerGame(players);
		newGame.deckOfCards.shuffleDeck();
		newGame.setAutoHandsForPlayers();
		newGame.printAllPlayerHands();
	}
}
