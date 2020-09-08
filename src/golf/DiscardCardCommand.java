package golf;

public class DiscardCardCommand implements Command, Cloneable {
	
	private DiscardPile discardPile;
	private PlayingCard card;
	private Player player;
	
	public DiscardCardCommand(DiscardPile discardPile, PlayingCard discard, Player player) {
		this.discardPile = discardPile;
		this.card = discard;
		this.player = player;
	}
	
	/**
	 * Adds a card to the discard pile.
	 */
	@Override
	public PlayingCard execute() {
		// TODO Auto-generated method stub
		discardPile.addCard(card);
		return card;
	}

	/**
	 * Removes a card from the discard pile.
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		discardPile.removeCard(card);
		
	}
	
	/**
	 * Sets up the command variables for next discard command.
	 * @param discard - card to be discarded
	 */
	public void resetDiscard(PlayingCard discard, Player player) {
		this.card = discard;
		this.player = player;
	}
	
	/**
	 * Gets and instance of this command to be pushed onto the stack.
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
	 * Gets the player name
	 * @return name of player 
	 */
	public String getPlayerName() {
		return player.getName();
	}
	
	/**
	 * Get card value--helper method for test
	 * @return card value
	 */
	public PlayingCard getCard() {
		return this.card;
	}
	
	
	/**
	 * Returns a string for printing.
	 */
	@Override
	public String toString() {
		return "DiscardCardCommand: retrieved " + card.toString() + " from discard pile";
	}

}
