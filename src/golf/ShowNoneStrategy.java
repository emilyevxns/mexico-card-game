package golf;

import java.util.ArrayList;

public class ShowNoneStrategy implements IStrategy {

	/**
	 * Forms the string that shows the correct amount of cards during game play.
	 * @param player name
	 */
	@Override
	public String showCards(Player player) {
		// TODO Auto-generated method stub
		String playerString = "\n" + player.getName() + ":\n";
		return playerString;
	}
}
