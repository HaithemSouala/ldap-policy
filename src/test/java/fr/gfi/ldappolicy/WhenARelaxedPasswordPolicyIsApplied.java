package fr.gfi.ldappolicy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author hsouala
 */
public class WhenARelaxedPasswordPolicyIsApplied extends PPolicyTestCase {

	@Override
	protected String getPPolicy() {
		return "relaxed";
	}

	@Override
	protected String getCompliantPassword() {
		return "abcd";
	}

	@Test
	public void aPasswordShorterThanFourCharactersShouldNotBeAccepted() {
		assertFalse(userManager.changePassword(USERNAME, PASSWORD, "abc"));
	}

	@Test
	public void fourFailedLoginAttemptsShouldBeAllowed() {
		failLogin(4);
		assertTrue(userManager.login(USERNAME, PASSWORD));
	}

	public void moreThanFourFailedLoginAttemptsShouldLockTheAccountOut() {
		failLogin(5);
		assertFalse(userManager.login(USERNAME, PASSWORD));
	}

	@Test
	public void aNewPasswordCanBeTheSameAsTheExistingOne() {
		assertTrue(userManager.changePassword(USERNAME, PASSWORD, PASSWORD));
	}
}
