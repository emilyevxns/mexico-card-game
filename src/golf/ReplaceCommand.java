package golf;

import java.util.ArrayList;

public class ReplaceCommand implements Command, Cloneable {

	private PlayingCard newCard, oldCard;
	private Player player;
	
	
	public ReplaceCommand(PlayingCard newCard, PlayingCard oldCard, Player player) {
		this.newCard = newCard;
		this.oldCard = oldCard;
		this.player = player;
	}
	
	/**
	 * Replaces the old card in hand with a new dark from the deck. 
	 */
	@Override
	public PlayingCard execute() {
		// TODO Auto-generated method stub
		player.replaceCard(oldCard, newCard);
		return null;
	}

	/**
	 * Replaces the new card in hand with the old card that was discarded.
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		player.undoReplaceCard(oldCard, newCard);

	}
	/**
	 * Resets the replaceCommand card values. Sets up for new replace command.
	 * @param newCard - card recently drawn from the deck
	 * @param oldCard - card that came from the hand
	 * @param player - player name 
	 */
	public void resetReplace(PlayingCard newCard, PlayingCard oldCard, Player player){
		this.newCard = newCard;
		this.oldCard = oldCard;
		this.player = player;
	}
	
	/**
	 * Creates an instance of this command to push onto the stack.
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
	 * Gets the player name
	 * @return name of player 
	 */
	public String getPlayerName() {
		return player.getName();
	}
	
	/**
	 * Returns a string representation of the last command so we can 
	 * print it out during undo.
	 */
	@Override
	public String toString() {
		return "ReplaceCommand: returned " + oldCard.toString() + " to the layout";
	}
	
	

}
