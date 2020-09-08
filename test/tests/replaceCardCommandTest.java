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
import golf.ReplaceCommand;

/**
 * Tests the ReplaceCommand class
 * @author emilyannevans
 *
 */
public class replaceCardCommandTest {

	private ReplaceCommand replaceCommand;
	private DiscardPile discardedCards;
	private Player computer;
	private Deck deck;
	private Player human;
	private DrawCommand drawCommand;
	private PlayingCard draw;
	private PlayingCard replace;
	ArrayList<PlayingCard> originalHand;
	

	@Before
	public void setUp() throws Exception {
		discardedCards = new DiscardPile();
		deck = new Deck(13);
		computer = new Player("Computer");
		replaceCommand = new ReplaceCommand(null, null, computer);
		drawCommand = new DrawCommand(deck, computer);
		//Deal initial cards to each player
		for (int i=0; i < Golf.START_CARDS; i++)
		{
			computer.draw(deck);
		}
		draw = drawCommand.execute();
		replace = computer.bestChoice(draw);
		originalHand = computer.getHand();
	}

	/**
	 * Tests the execute method
	 */
	@Test
	public void testExecute() {
		replaceCommand.resetReplace(draw, replace, computer);
		replaceCommand.execute();
		ArrayList<PlayingCard> replaceCommandHand = computer.getHand();
		computer.replaceCard(replace, draw);
		ArrayList<PlayingCard> computerReplaceHand = computer.getHand();
		assertEquals(computerReplaceHand, replaceCommandHand);
		
	}
	
	/**
	 * Tests the execute method again
	 */
	@Test
	public void testAnotherExecute() {
		replaceCommand.resetReplace(draw, replace, computer);
		replaceCommand.execute();
		ArrayList<PlayingCard> replaceCommandHand = computer.getHand();
		computer.replaceCard(replace, draw);
		ArrayList<PlayingCard> computerReplaceHand = computer.getHand();
		assertEquals(computerReplaceHand, replaceCommandHand);
		
	}
	
	/**
	 * Tests the undo method
	 */
	@Test
	public void testUndo() {
		replaceCommand.execute();
		replaceCommand.undo();
		computer.replaceCard(replace, draw);
		ArrayList<PlayingCard> computerUndoHand = computer.getHand();
		assertEquals(originalHand, computerUndoHand);
	}
	
	/**
	 * Tests the undo method again
	 */
	@Test
	public void testAnotherUndo() {
		replaceCommand.execute();
		replaceCommand.undo();
		computer.replaceCard(replace, draw);
		ArrayList<PlayingCard> computerUndoHand = computer.getHand();
		assertEquals(originalHand, computerUndoHand);
	}

}
