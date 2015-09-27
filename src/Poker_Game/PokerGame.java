package Poker_Game;

import java.util.Scanner;

public class PokerGame {

	public Players[] players;
	public int numberOfPlayers; 
	public Deck deckOfCards;

	// Constructor
	PokerGame(int players){
		this.numberOfPlayers = players;
		this.deckOfCards = new Deck();
		this.players = new Players[this.numberOfPlayers];
		for(int i = 0 ; i < this.numberOfPlayers; i++){
			this.players[i] = new Players(i+1);
		}
	}



	/* MAIN Method 
	 * Start Simple Poker Game
	 */
	public static void main (String [] args){		
		Scanner a = new Scanner(System.in);		

		System.out.println("How many players are there (can only be between 2-5 payers)?");
		int players = a.nextInt();		
		while (players < 2 || players > 5){
			System.out.println("Invalid number of players, can only have between 2-5 players");
			players = a.nextInt();
		}

		PokerGame newGame = new PokerGame(players);
		newGame.deckOfCards.shuffleDeck();
	}
}
