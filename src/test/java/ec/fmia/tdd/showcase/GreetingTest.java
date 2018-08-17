package ec.fmia.tdd.showcase;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class GreetingTest {

	@Test
	public void methodGreetThatInterpolatesNameInASimpleGreeting() {
		Assert.assertEquals("Hello, Bob.", Greeting.greet("Bob"));
	}

	@Test
	@Ignore
	public void methodGreetThatInterpolatesNameWhenNameIsNull() {
		// Assert.assertEquals("Hello, my friend.", Greeting.greet(null));
	}

	@Test
	public void methodWhenNameIsAllUppercaseThenShouldAllUppercase() {
		Assert.assertEquals("HELLO, VIVIANA.", Greeting.greet("VIVIANA"));
	}

	@Test
	public void methodWhenNameIsAnArrayOfTwoNamesThenBothNamesShouldBePrinted() {
		String[] names = new String[2];
		names[0] = "Mati";
		names[1] = "Vivi";
		Assert.assertEquals("Hello, Mati and Vivi.", Greeting.greet(names));
	}

	@Test
	public void methodWhenNameIsAnArrayOfTwoNamesThenBothNamesShouldBePrintedThenShouldAllUppercase() {
		String[] names = new String[3];
		names[0] = "MATO";
		names[1] = "VIVI";
		names[2] = "FRED";
		Assert.assertEquals("HELLO, MATO, VIVI AND FRED.", Greeting.greet(names));
	}

	@Test
	public void methodWhenNameIsAnArrayOfTwoNamesThenBothNamesShouldBePrintedThenShouldAllLowercase() {
		String[] names = new String[3];
		names[0] = "Mati";
		names[1] = "Vivi";
		names[2] = "FRED";
		Assert.assertEquals("Hello, Mati, Vivi and FRED.", Greeting.greet(names));
	}

	public void methodAllowMixingOfNormalAndShoutedNamesBySeparatingTheResponseIntoTwoGreetings() {

	}

}