package golf;

import java.util.ArrayList;

/**
 * Interface for the show cards strategies
 * @author emilyannevans
 *
 */
public interface IStrategy {
	
	/**
	 * Forms the string that shows the correct amount of cards during gameplay.
	 * @param player name
	 */
	public String showCards(Player player);
}
