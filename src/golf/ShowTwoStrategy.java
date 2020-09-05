package golf;

import java.util.ArrayList;

public class ShowTwoStrategy implements IStrategy {

	/**
	 * Forms the string that shows the correct amount of cards during game play.
	 * @param player name
	 */
	@Override
	public String showCards(Player player) {
		String playerString = "\n" + player.getName() + ":\n";
		String cards = "";
		ArrayList<PlayingCard> playerHand = player.getHand();
		for (int i = 0; i < 2; i++) {
			if (i < 2) {
				cards += playerHand.get(i).toString() + "\n";
			} else {
				cards += "Card "+(i+1) + "\n";
			}
		}
		return playerString + cards;
	}
	
	

}
