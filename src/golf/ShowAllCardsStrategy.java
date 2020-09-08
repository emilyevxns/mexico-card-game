package golf;

import java.util.ArrayList;

/**
 * Performs the show all cards strategy action
 * @author emilyannevans
 *
 */
public class ShowAllCardsStrategy implements IStrategy {

	/**
	 * Forms the string that shows the correct amount of cards during game play.
	 * @param player name
	 */
	@Override
	public String showCards(Player player) {
		// TODO Auto-generated method stub
		return player.toString();
	}

}
