package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ allCardsTest.class, CommandPatternTests.class, discardCardCommandTest.class,
		drawFromDeckCommandTest.class, noCardsTest.class, pickUpDiscardCommandTest.class, replaceCardCommandTest.class,
		StrategyPatternTests.class, twoCardsTest.class })
public class AllProjectTests {

}
