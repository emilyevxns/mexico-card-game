package tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import golf.Deck;
import golf.DiscardCardCommand;
import golf.DiscardPile;
import golf.DrawCommand;
import golf.DrawDiscardCommand;
import golf.Golf;
import golf.Player;
import golf.PlayingCard;
import golf.ReplaceCommand;

/**
 * Runs all tests on the Command Pattern
 * @author emilyannevans
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ discardCardCommandTest.class, drawFromDeckCommandTest.class, pickUpDiscardCommandTest.class,
		replaceCardCommandTest.class })
public class CommandPatternTests {
}
