package Poker_Game;

public class Hands {
	
	public String[] hands;
	public int ace, two , three, four, five, six, seven, eight, nine, ten, jack, queen, king;
	public int hearts, diamonds, spade, clubs;


	// Constructor
	public Hands(){
		hands = new String[5];
		ace = two = three = four = five = six = seven = eight = nine = ten = jack = queen = king = 0;
		hearts = diamonds = spade = clubs = 0;
	}
}
