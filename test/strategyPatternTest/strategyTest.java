package strategyPatternTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import golf.Deck;
import golf.DiscardPile;
import golf.Golf;
import golf.Player;
import golf.PlayingCard;
import golf.ShowAllCardsStrategy;
import golf.ShowNoneStrategy;
import golf.ShowTwoStrategy;

public class strategyTest {
	
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
	
	@Test
	public void showAllTest() {
		ShowAllCardsStrategy showAll = new ShowAllCardsStrategy();
		expected =  "\n" + computer.getName() + ":\n";
		for (PlayingCard card: cardsInHand) {
			expected += card.getTypeName(card.getType()) + " of " + card.getSuit() + "\n";
		}
		assertEquals(expected, showAll.showCards(computer));
	}
	
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




