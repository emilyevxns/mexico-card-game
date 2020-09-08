package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import golf.Deck;
import golf.DiscardCardCommand;
import golf.DiscardPile;
import golf.DrawCommand;
import golf.Golf;
import golf.Player;
import golf.PlayingCard;

/**
 * Tests the DrawCommand class
 * @author emilyannevans
 *
 */
public class drawFromDeckCommandTest {
	private DiscardPile discardedCards;
	private Player computer;
	private Deck deck;
	private ArrayList<PlayingCard> cardsInHand;
	private DrawCommand drawCommand;
	

	@Before
	public void setUp() throws Exception {
		discardedCards = new DiscardPile();
		deck = new Deck(13);
		computer = new Player("Computer");
		drawCommand = new DrawCommand(deck, computer);
		//Deal initial cards to each player
		for (int i=0; i < Golf.START_CARDS; i++)
		{
			computer.draw(deck);
		}
		cardsInHand = computer.getHand();;
	}

	/**
	 * Tests the execute method
	 */
	@Test
	public void testExecute() {
		PlayingCard card = deck.getTop();
		assertEquals(card, drawCommand.execute());
	}
	
	/**
	 * Tests the execute method again
	 */
	@Test
	public void testAntherExecute() {
		PlayingCard card = deck.getTop();
		assertEquals(card, drawCommand.execute());
	}
	
	/**
	 * Tests the undo method
	 */
	@Test
	public void testUndo() {
		PlayingCard card = deck.getTop();
		drawCommand.execute();
		drawCommand.undo();
		assertEquals(card, deck.getTop());
	}
	
	/**
	 * Tests the undo method again
	 */
	@Test
	public void testAnotherUndo() {
		PlayingCard card = deck.getTop();
		drawCommand.execute();
		drawCommand.undo();
		assertEquals(card, deck.getTop());
	}
}
