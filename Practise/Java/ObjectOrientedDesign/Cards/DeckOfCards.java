import java.lang.Math;
/**
	Problems: "Design the data structures for a generic deck of cards. Explain how you would
	subclass the data structures to implement blackjack"
	Discussion: the task seems almost trivial
	*/
public class DeckOfCards
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		System.out.println(deck.cards[2].rank); //-> 4
		deck.Shuffle(100);
		System.out.println(deck.cards[2].rank);
	}
}

class Deck
{
	public Card[] cards = new Card[52];
	private int cardsDrawn = 0;
	
	public Deck()
	{
		char[] ranks = {'2','3','4','5','6','7','8','9','0','J','Q','K','A'};
		char[] suits = {'s','h','c','d'};
		int counter = 0;
		
		for (char suit : suits)
		{
			for (char rank : ranks)
			{
				cards[counter] = new Card(rank, suit);
				counter++;
			}
		}
	}
	
	public void Shuffle(int swaps)
	{
		Card swapperCard;
		int randomNumber;
		for(int i = 0; i < swaps; i++)
		{
			randomNumber = (int) Math.floor(Math.random()*50);
			swapperCard = cards[randomNumber];
			cards[randomNumber] = cards[51];
			cards[51] = swapperCard;
		}
	}
}

class Card
{
	public char rank;
	public char suit;
	
	public Card(char rank, char suit)
	{
		this.suit = suit;
		this.rank = rank;
	}
}