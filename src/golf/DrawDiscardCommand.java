package golf;

/**
 * Performs the DrawDiscardCommand-- draws card from discard pile
 * @author emilyannevans
 *
 */
public class DrawDiscardCommand implements Command, Cloneable {
	
	private DiscardPile discards;
	private PlayingCard card;
	private Player player;
	
	
	public DrawDiscardCommand(DiscardPile discards, Player player) {
		this.discards = discards;
		this.player = player;
	}
	
	/**
	 * Draws a card from the discard pile
	 * @return card that was just drawn
	 */
	@Override
	public PlayingCard execute() {
		card = discards.draw();
		return card;
	}

	/**
	 * Adds a card to the discard pile
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		discards.addCard(card);
	}

	/**
	 * Gets and instance of this command to be pushed onto the stack.
	 * @return this command instance
	 */
	public Command getCommand() {
		try {
			return (Command) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
		}	
		return null;
	}
	
	/**
	 * Assigns new draw to a player
	 * @param player that is drawing
	 */
	public void resetDrawCommand(Player player) {
		this.player = player;
	}
	
	
	/**
	 * Returns a string for printing.
	 */
	@Override
	public String toString() {
		return "DrawDiscardCommand: returned " + card.toString() + " to discard pile";
	}

}
