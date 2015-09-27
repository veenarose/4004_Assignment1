package Poker_Game;

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
}
