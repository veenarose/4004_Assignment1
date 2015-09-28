package Poker_Game;

public class Players {

	public int playerID;
	public Hands playerHand;
	public String flush;
	
	/*
	 * @deprecated use{Players(int a)}
	 */
	Players (){
		this.playerID = 0;
		this.playerHand = null;
		this.flush = null;
	}
	
	public Players(int id){
		this.playerID = id;
		this.playerHand = new Hands();
		this.flush = null;
	}
	
	public void printPlayerHand(){
		System.out.println("Player " +this.playerID +" Hand :");
		this.playerHand.printHands();
	}
}

