package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import Poker_Game.Deck;
import Poker_Game.Hands;
import Poker_Game.Players;
import Poker_Game.PokerGame;

public class TestCard {
	Deck deck = new Deck();
	PokerGame game;
	Hands hand;

	@Test
	public void testNumberOfCardsInDeck(){
		assertTrue("This deck may not have all the cards in it !!",deck.cards.length == 52); 		
	}

	@Test 
	public void testDupelicateCards(){
		int ace, two , three, four, five, six, seven, eight, nine, ten, jack, queen, king, clubs, diamonds, spade, hearts;
		ace = two = three = four = five = six = seven = eight = nine = ten = queen = king = jack = clubs = spade = hearts = diamonds =0;

		String card;
		for (int i = 0 ; i < 52 ; i++){
			card = deck.cards[i];
			if (card.contains("Ace")) { ace++;}
			if (card.contains("Two")) { two++;}
			if (card.contains("Three")) { three++;}
			if (card.contains("Four")) { four++;}
			if (card.contains("Five")) { five++;}
			if (card.contains("Six")) { six++;}
			if (card.contains("Seven")) { seven++;}
			if (card.contains("Eight")) { eight++;}
			if (card.contains("Nine")) { nine++;}
			if (card.contains("Ten")) { ten++;}
			if (card.contains("Jack")) { jack++;}
			if (card.contains("Queen")) { queen++;}
			if (card.contains("King")) { king++;}
			if (card.contains("Clubs")){ clubs++; }
			if (card.contains("Spades")){ spade++; }
			if (card.contains("Diamonds")){ diamonds++; }
			if (card.contains("Hearts")){ hearts++; }

		}
		// Check for suites
		assertTrue("Number of Spades in the deck is not 13 ", spade == 13);
		assertTrue("Number of Diamonds in the deck is not 13 ", diamonds == 13);
		assertTrue("Number of Hearts in the deck is not 13 ", hearts == 13);
		assertTrue("Number of Clubs in the deck is not 13 ", clubs == 13);

		// Check for ranks
		assertTrue("Number of Ace in the deck is not 4 ", ace == 4);
		assertTrue("Number of Two in the deck is not 4 ", two == 4);
		assertTrue("Number of Three in the deck is not 4 ", three == 4);
		assertTrue("Number of Four in the deck is not 4 ", four == 4);
		assertTrue("Number of Five in the deck is not 4 ", five == 4);
		assertTrue("Number of Six in the deck is not 4 ", six == 4);
		assertTrue("Number of Seven in the deck is not 4 ", seven == 4);
		assertTrue("Number of Eight in the deck is not 4 ", eight == 4);
		assertTrue("Number of Nine in the deck is not 4 ", nine == 4);
		assertTrue("Number of Ace in the deck is not 4 ", ten == 4);
		assertTrue("Number of Jack in the deck is not 4 ", jack == 4);
		assertTrue("Number of Queen in the deck is not 4 ", queen == 4);
		assertTrue("Number of King in the deck is not 4 ", king == 4);
	}

	@Test
	public void testInvalidCardsInDeck(){
		// You can change the names of the invalid cards here
		String invalidCardName1 = "FourteenCubs";
		String invalidCardName2 = "ThreeShovels";
		String invalidCardName3 = "TwoCubes";
		String invalidCardName4 = "ThDiamonds";

		for(int i = 0 ; i < deck.cards.length ; i++){
			assertTrue("The deck contains invalid card names!!",!((deck.cards[i].contains(invalidCardName1)|| deck.cards[i].contains(invalidCardName2)
					||deck.cards[i].contains(invalidCardName3)|| deck.cards[i].contains(invalidCardName4))));					
		}		
	}

	@Test //( This test must fail )
	public void testMinimumPlayers() throws Exception{
		game = new PokerGame(-2);
	}

	@Test //( This test must fail )
	public void testMaximumPlayers() throws Exception{
		game = new PokerGame(7);
	}

	@Test
	public void testNumberOfHandsDealt(){
		hand = new Hands();
		assertTrue("This hand may not have 5 cards ", hand.hands.length == 5); 		
	}

	@Test
	public void testPlayerIdCheck() throws Exception{
		game = new PokerGame(3);
		assertTrue("The first player Id is wrong", game.players[0].playerID == 1);
		assertTrue("The second player Id is wrong", game.players[1].playerID == 2);
		assertTrue("The third player Id is wrong", game.players[2].playerID == 3);

	}

	@Test
	public void testHandsAreRanked() throws Exception{
		game = new PokerGame(2);
		game.setHandsManually(1, "TwoHearts", "FourSpades", "QueenDiamonds", "SevenClubs", "KingClubs");

		int[] arr = new int[5];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = game.players[1].playerHand.handRank[i];
		}

		// Check if rank array is sorted every time you insert an hand 
		boolean sorted = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i+1]) {
				sorted = false;
				break;
			}
		}
		assertTrue("The Hand rank array that represents the rank for hands in integers are not ranked or sorted", sorted);
		game.players[1].printPlayerHand();
	}

	@Test
	public void testOrderOfEntry() throws Exception{
		game = new PokerGame(2);
		game.setHandsManually(1, "TwoHearts", "FourSpades", "QueenDiamonds", "SevenClubs", "KingClubs");
	}

	@Test
	public void chechDupeHands() throws Exception{
		game = new PokerGame(2);
		game.setAutoHandsForPlayers();
		
		game.players[0].playerHand.findHandRank();
	}
}
