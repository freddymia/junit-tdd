package ec.fmia.tdd.showcase;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

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