package ec.fmia.tdd.showcase;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
Create a Password verifications class called “PasswordVerifier”.

1. Add the following verifications to a master function called “Verify()”
	1 - password should be larger than 8 chars
	2 - password should not be null
	3 - password should have one uppercase letter at least
	4 - password should have one lowercase letter at least
	5 - password should have one number at least

	Each one of these should throw an exception with a different message of your choosing

2. Add feature: Password is OK if at least three of the previous conditions is true
3. Add feature: password is never OK if item 1.4 is not true.
4. Assume Each verification takes 1 second to complete. How would you solve  items 2 and 3  so tests can run faster?

 **/
public class PasswordVerifierTest {

	@Test(expected = RuntimeException.class)
	public final void passwordShouldBeLargerThan8Chars() {
		PasswordVerifier.verify("123456");
	}

	@Test(expected = RuntimeException.class)
	public final void passwordShouldNoBeNull() {
		PasswordVerifier.verify(null);
	}

	@Test
	public final void passwordShouldHaveOneUppercaseLetterAtLeast() {
		PasswordVerifier.verify("798w7erEwe98");
		Assert.assertTrue(true);
	}

	@Test
	public final void passwordShouldHaveOneLowercaseLetterAtLeast() {
		PasswordVerifier.verify("798w7erEwe98.");
		Assert.assertTrue(true);
	}

	@Test
	public final void passwordShouldHaveOneNumberAtLeast() {
		PasswordVerifier.verify("798w7erEwe98");
		Assert.assertTrue(true);
	}

	/** MESSAGES **/
	@Test
	@Ignore
	public final void passwordShouldBeLargerThan8CharsMessage() {

		RuntimeException exception = null;

		try {
			PasswordVerifier.verify("1234");
		} catch (RuntimeException e) {
			exception = e;
		}

		Assert.assertNotNull(exception);
		Assert.assertEquals("Password should be larger than 8 chars.", exception.getMessage());
	}

	@Test
	@Ignore
	public final void passwordShouldNoBeNullMessage() {

		RuntimeException exception = null;

		try {
			PasswordVerifier.verify(null);
		} catch (RuntimeException e) {
			exception = e;
		}

		Assert.assertNotNull(exception);
		Assert.assertEquals("Password should not be null.", exception.getMessage());
	}

	@Test
	@Ignore
	public final void passwordShouldHaveOneUppercaseLetterAtLeastMessage() {

		RuntimeException exception = null;

		try {
			PasswordVerifier.verify("sdafsdfsdfsdf");
		} catch (RuntimeException e) {
			exception = e;
		}

		Assert.assertNotNull(exception);
		Assert.assertEquals("Password must have at least one uppercase character.", exception.getMessage());
	}

	@Test
	@Ignore
	public final void passwordShouldHaveOneLowercaseLetterAtLeastMessage() {

		RuntimeException exception = null;

		try {
			PasswordVerifier.verify("WEERAREAEREER464");
		} catch (RuntimeException e) {
			exception = e;
		}

		Assert.assertNotNull(exception);
		Assert.assertEquals("Password must have at least one lowercase character.", exception.getMessage());
	}

	@Test
	@Ignore
	public final void passwordShouldHaveOneNumberAtLeastMessage() {
		RuntimeException exception = null;

		try {
			PasswordVerifier.verify("qwerqAasdadfasfRTRT");
		} catch (RuntimeException e) {
			exception = e;
		}

		Assert.assertNotNull(exception);
		Assert.assertEquals("Password must have at least one number character.", exception.getMessage());
	}

	@Test
	public final void passwordIsOKIfAtLeastThreeOfThePreviousConditionsIsTrue() {
		Assert.assertEquals(true, PasswordVerifier.verify("25Eq4"));
	}

}