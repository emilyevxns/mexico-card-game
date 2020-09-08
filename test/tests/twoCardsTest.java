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
import golf.ShowTwoStrategy;

/**
 * Tests the ShowTwoStrategy class
 * @author emilyannevans
 *
 */
public class twoCardsTest {

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
	 * Tests the showCards method 
	 */
	@Test
	public void showTwoTest() {
		ShowTwoStrategy showTwo = new ShowTwoStrategy();
		expected =  "\n" + computer.getName() + ":\n";
		int index = 0;
		for (PlayingCard card: cardsInHand) {
			index++;
			expected += card.getTypeName(card.getType()) + " of " + card.getSuit() + "\n";
			if (index == 2) {
				assertEquals(expected, showTwo.showCards(computer));
			}
		}
	}

}
