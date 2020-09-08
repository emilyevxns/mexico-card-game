package golf;

/**
 * Defines the Command interface
 * @author emilyannevans
 *
 */
public interface Command {
	/**
	 * Executes requested action
	 * @return playing card value
	 */
	public PlayingCard execute();
	
	/**
	 * Undoes an executed action
	 */
	public void undo();
}
