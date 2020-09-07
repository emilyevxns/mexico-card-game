package golf;

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
	 * Returns a string for printing.
	 */
	@Override
	public String toString() {
		return "DrawDiscardCommand: returned " + card.toString() + " to discard pile";
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
	
	

}
