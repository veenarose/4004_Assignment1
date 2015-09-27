package Poker_Game;

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
}
