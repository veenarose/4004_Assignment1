package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import Poker_Game.Deck;

public class TestCard {
	
	@Test
	public void testNumberOfCardsInDeck(){
		Deck deck = new Deck();
		assertTrue("This deck may not have all the cards in it !!",deck.cards.length == 52); 		
	}
}
