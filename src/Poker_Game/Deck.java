package Poker_Game;

public class Deck {
	public String [] cards;	

	public Deck(){
		cards = new String[52];

	}
	
	// Hearts
		private class Hearts{
			private String [] heartsSuits;
			Hearts(){
				heartsSuits = new String [13];
				heartsSuits[0] = "AceHearts";
				heartsSuits[1] = "TwoHearts";
				heartsSuits[2] = "ThreeHearts";
				heartsSuits[3] = "FourHearts";
				heartsSuits[4] = "FiveHearts";
				heartsSuits[5] = "SixHearts";
				heartsSuits[6] = "SevenHearts";
				heartsSuits[7] = "EightHearts";
				heartsSuits[8] = "NineHearts";
				heartsSuits[9] = "TenHearts";
				heartsSuits[10] = "JackHearts";
				heartsSuits[11] = "QueenHearts";
				heartsSuits[12] = "KingHearts";					
			}
		}

		// Diamonds
		private class Diamonds{
			private String [] diamondsSuits;
			Diamonds(){
				diamondsSuits = new String [13];
				diamondsSuits[0] = "AceDiamonds";
				diamondsSuits[1] = "TwoDiamonds";
				diamondsSuits[2] = "ThreeDiamonds";
				diamondsSuits[3] = "FourDiamonds";
				diamondsSuits[4] = "FiveDiamonds";
				diamondsSuits[5] = "SixDiamonds";
				diamondsSuits[6] = "SevenDiamonds";
				diamondsSuits[7] = "EightDiamonds";
				diamondsSuits[8] = "NineDiamonds";
				diamondsSuits[9] = "TenDiamonds";
				diamondsSuits[10] = "JackDiamonds";
				diamondsSuits[11] = "QueenDiamonds";
				diamondsSuits[12] = "KingDiamonds";					
			}
		}

		// Spades
		private class Spades{
			private String [] spadeSuits;
			Spades(){
				spadeSuits = new String [13];
				spadeSuits[0] = "AceSpades";
				spadeSuits[1] = "TwoSpades";
				spadeSuits[2] = "ThreeSpades";
				spadeSuits[3] = "FourSpades";
				spadeSuits[4] = "FiveSpades";
				spadeSuits[5] = "SixSpades";
				spadeSuits[6] = "SevenSpades";
				spadeSuits[7] = "EightSpades";
				spadeSuits[8] = "NineSpades";
				spadeSuits[9] = "TenSpades";
				spadeSuits[10] = "JackSpades";
				spadeSuits[11] = "QueenSpades";
				spadeSuits[12] = "KingSpades";					
			}
		}

		// Clubs
		private class Clubs{
			private String [] clubsSuits;
			Clubs(){
				clubsSuits = new String [13];
				clubsSuits[0] = "AceClubs";
				clubsSuits[1] = "TwoClubs";
				clubsSuits[2] = "ThreeClubs";
				clubsSuits[3] = "FourClubs";
				clubsSuits[4] = "FiveClubs";
				clubsSuits[5] = "SixClubs";
				clubsSuits[6] = "SevenClubs";
				clubsSuits[7] = "EightClubs";
				clubsSuits[8] = "NineClubs";
				clubsSuits[9] = "TenClubs";
				clubsSuits[10] = "JackClubs";
				clubsSuits[11] = "QueenClubs";
				clubsSuits[12] = "KingClubs";					
			}
		}
}
