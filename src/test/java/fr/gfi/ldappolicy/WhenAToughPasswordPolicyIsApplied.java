package fr.gfi.ldappolicy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author tomasz
 */
public class WhenAToughPasswordPolicyIsApplied extends PPolicyTestCase {

	@Override
	protected String getPPolicy() {
		return "tough";
	}

	@Override
	protected String getCompliantPassword() {
		return "abcdefg";
	}

	@Test
	public void aPasswordShorterThanSevenCharactersShouldNotBeAccepted() {
		assertFalse(userManager.changePassword(USERNAME, PASSWORD, "abcdef"));
	}

	@Test
	public void twoFailedLoginAttemptsShouldBeAllowed() {
		failLogin(2);
		assertTrue(userManager.login(USERNAME, PASSWORD));
	}

	public void moreThanTwoFailedLoginAttemptsShouldLockTheAccountOut() {
		failLogin(3);
		assertFalse(userManager.login(USERNAME, PASSWORD));
	}

	@Test
	public void aNewPasswordShouldBeDifferentFromTheExistingOne() {
	}
}
