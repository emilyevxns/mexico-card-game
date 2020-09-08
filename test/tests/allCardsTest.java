package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import golf.Deck;
import golf.Golf;
import golf.Player;
import golf.PlayingCard;
import golf.ShowAllCardsStrategy;

/**
 * Tests the ShowAllCardsStrategy 
 * @author emilyannevans
 *
 */
public class allCardsTest {
	private Golf golf;
	private Deck deck;
	private Player human;
	private Player computer;
	private ArrayList<PlayingCard> cardsInHand;
	private String expected;
	
	@Before
	public void setUp() throws Exception {
		golf = new Golf();
		deck = new Deck(13);
		human = new Player("Human");
		computer = new Player("Computer");
		//Deal initial cards to each player
		for (int i=0; i < Golf.START_CARDS; i++)
		{
			human.draw(deck);
			computer.draw(deck);
		}
		cardsInHand = computer.getHand();;
	}
	

	@Test
	public void showAllTest() {
		ShowAllCardsStrategy showAll = new ShowAllCardsStrategy();
		expected =  "\n" + computer.getName() + ":\n";
		for (PlayingCard card: cardsInHand) {
			expected += card.getTypeName(card.getType()) + " of " + card.getSuit() + "\n";
		}
		assertEquals(expected, showAll.showCards(computer));
	}

}
