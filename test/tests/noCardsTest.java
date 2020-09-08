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
import golf.ShowNoneStrategy;

/**
 * Tests the ShowNoneStrategy class
 * @author emilyannevans
 *
 */
public class noCardsTest {
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
	
	/**
	 * Tests showCards method of ShowNoneStrategy 
	 */
	@Test
	public void showNoneTest() {
		ShowNoneStrategy showNone = new ShowNoneStrategy();
		expected =  "\n" + computer.getName() + ":\n";
		assertEquals(expected, showNone.showCards(computer));
	}
}
