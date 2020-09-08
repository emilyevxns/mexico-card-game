package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ allCardsTest.class, noCardsTest.class, twoCardsTest.class })
public class StrategyPatternTests {

}
