package golf;

import java.util.ArrayList;

public class DrawCommand implements Command, Cloneable {

	private Deck deck;
	private PlayingCard card;
	private Player player;
	
	public DrawCommand(Deck deck, Player player) {
		this.deck = deck;
		this.player = player;
	}
	
	/**
	 * Draws a card from the deck.
	 */
	@Override
	public PlayingCard execute() {
		// TODO Auto-generated method stub

		card = deck.draw();
		return card;
	}

	/**
	 * Returns card to the deck.
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		deck.returnDraw(card);
	}
	
	/**
	 * Gets an instance of this command to push onto the stack
	 * @return this Command instance
	 */
	public Command getCommand() {
		try {
			return (Command) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	/**
	 * Assigns draw to a player
	 * @param player that is drawing
	 */
	public void resetDrawCommand(Player player) {
		this.player = player;
	}
	
	/**
	 * Gets the player name
	 * @return name of player 
	 */
	public String getPlayerName() {
		return player.getName();
	}
	

	/**
	 * Returns a string summarizing the command undo for printing 
	 */
	@Override
	public String toString() {
		return "DrawCommand: returned "+ card.toString() + " to the deck";
	}

}
