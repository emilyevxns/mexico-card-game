package tests;

import static org.junit.Assert.*;

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
 * Tests the Draw Djscard Command
 * @author emilyannevans
 *
 */
public class pickUpDiscardCommandTest {
	private DiscardCardCommand discardCommand;
	private DiscardPile discardedCards;
	private Player computer;
	private Deck deck;
	private Player human;
	private DrawCommand drawCommand;
	private DrawDiscardCommand drawDiscard;
	

	@Before
	public void setUp() throws Exception {
		discardedCards = new DiscardPile();
		deck = new Deck(13);
		computer = new Player("Computer");
		discardCommand = new DiscardCardCommand(discardedCards, null, computer);
		drawCommand = new DrawCommand(deck, computer);
		drawDiscard = new DrawDiscardCommand(discardedCards, computer);
		//Deal initial cards to each player
		for (int i=0; i < Golf.START_CARDS; i++)
		{
			computer.draw(deck);
		}
	}

	@Test
	public void test() {
		PlayingCard deckCard = drawCommand.execute();
		discardCommand.resetDiscard(deckCard, computer);
		discardCommand.execute();
		drawDiscard.resetDrawCommand(computer);
		assertEquals(deckCard, drawDiscard.execute());
	}
	
	
	@Test 
	public void testUndo() {
		PlayingCard deckCard = drawCommand.execute();
		discardCommand.resetDiscard(deckCard, computer);
		discardCommand.execute();
		PlayingCard discardCard = drawDiscard.execute();
		drawDiscard.undo();
		PlayingCard discardTopCard = discardedCards.getTop();
		assertEquals(discardCard, discardTopCard);
	}

}
