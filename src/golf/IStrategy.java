package golf;

import java.util.ArrayList;

public interface IStrategy {
	/**
	 * Forms the string that shows the correct amount of cards during gameplay.
	 * @param player name
	 */
	public String showCards(Player player);
}
