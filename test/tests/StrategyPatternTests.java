package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all tests for the strategy pattern implementations
 * @author emilyannevans
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ allCardsTest.class, noCardsTest.class, twoCardsTest.class })
public class StrategyPatternTests {

}
