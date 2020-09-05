package golf;

/**
 * Represents a playing card
 * @author jburge
 *
 */
public class PlayingCard implements Comparable<Object> {
	
	public static int MIN = 1;
	public static int MAX = 13; 
	public static int INVALID = -1;
	
	public static int ACE = 1;
	public static int JACK = 11;
	public static int QUEEN = 12;
	public static int KING = 13;
	
	public static String HEARTS = "Hearts";
	public static String CLUBS = "Clubs";
	public static String DIAMONDS = "Diamonds";
	public static String SPADES = "Spades";
	
	private static String types[] = {null, "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
		"Nine", "Ten", "Jack", "Queen", "King"};
	
	private String suit;
	private int type;

	public PlayingCard(String suit, int type) {
		super();
		this.suit = suit;
		this.type = type;
	}
	
	/**
	 * Gives a nice readable name
	 * @param value - the integer value of the card
	 * @return - a spelled out name
	 */
	public static String getName(int value) {
		return types[value];
	}
	
	/**
	 * Given a name, or partially spelled out name, gets the value
	 * @param name - a string such as "ace" or "aces"
	 * @return - the integer value or INVALID
	 */
	public static int determineType(String name)
	{
		for (int i=1; i < types.length; i ++)
		{
			if (name.toLowerCase().contains(types[i].toLowerCase()))
			{
				return i;
			}	
		}
		return INVALID;
	}
	
	/**
	 * Returns the suit of the playing card.
	 * @return string suit name 
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * Sets the suit of the playing card.
	 * @param suit name
	 */ 
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	/**
	 * Gets the type of the playing card
	 * @return type number
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Sets the type of the playing card
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}
	

	
	/**
	 * This assumes that an Ace will have a value of 1
	 * @return
	 */
	public int value()
	{
		if (type >= 10)
		{
			return 10;
		}
		return type;
	}
	

	public boolean equalsType(int type) { // need to write proper equals method ???
		return this.type == type;
	}
	
	/**
	 * A proper equals method for the playing card. Notice that it takes in an Object as the parameter
	 */
	public boolean equals(Object o) {
		if (o == null)
		{
			return false;
		}
		if (o.getClass() == this.getClass())
		{
			PlayingCard card = (PlayingCard) o;
			if (card.suit.equals(this.suit) && (card.type == this.type))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Compares two playing cards. Again, notice that it takes in an Object.
	 */
	public int compareTo(Object o) {
		if ((o == null) || (!(o instanceof PlayingCard)))
		{
			return -100; //kludge
		}
		PlayingCard card = (PlayingCard) o;
		if (this.getType() < card.getType())
		{
			return -1;
		}
		else if (this.getType() == card.getType())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}

	/**
	 * Returns a string version of the card to use when printing
	 */
	public String toString()
	{
		return types[type] + " of " + suit;
	}
	
}
