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
import golf.DrawDiscardCommand;
import golf.Golf;
import golf.Player;
import golf.PlayingCard;
/**
 * Tests the Discard Card Command
 * @author emilyannevans
 *
 */
public class discardCardCommandTest {
	private DiscardCardCommand discardCommand;
	private DiscardPile discardedCards;
	private Player computer;
	private Deck deck;
	private Player human;
	private DrawCommand drawCommand;
	

	@Before
	public void setUp() throws Exception {
		discardedCards = new DiscardPile();
		deck = new Deck(13);
		computer = new Player("Computer");
		discardCommand = new DiscardCardCommand(discardedCards, null, computer);
		drawCommand = new DrawCommand(deck, human);
		//Deal initial cards to each player
		for (int i=0; i < Golf.START_CARDS; i++)
		{
			computer.draw(deck);
		}
	}

	/**
	 * Tests the execute method
	 */
	@Test
	public void testExecute() {
		PlayingCard card = drawCommand.execute();
		discardCommand.resetDiscard(card, computer);
		discardCommand.execute();
		assertEquals(card, discardedCards.getTop());
	}
	/**
	 * Tests the execute method again
	 */
	@Test
	public void testAnotherExecute() {
		PlayingCard card = drawCommand.execute();
		discardCommand.resetDiscard(card, computer);
		discardCommand.execute();
		assertEquals(card, discardedCards.getTop());
	}
	
	/**
	 * Tests the undo method
	 */
	@Test
	public void testUndo() {
		PlayingCard card = drawCommand.execute();
		discardCommand.resetDiscard(card, computer);
		discardCommand.execute();
		discardCommand.undo();
		assertTrue(discardedCards.getDiscards().isEmpty());
	}
	
	/**
	 * Tests the undo method again
	 */
	@Test
	public void testAnotherUndo() {
		PlayingCard card = drawCommand.execute();
		discardCommand.resetDiscard(card, computer);
		discardCommand.execute();
		discardCommand.undo();
		assertTrue(discardedCards.getDiscards().isEmpty());
	}

}
