package fr.gfi.ldappolicy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Focuses on password policy.
 * 
 * @author hsouala
 */
public abstract class PPolicyTestCase extends AppTestCase {

	protected abstract String getPPolicy();

	protected abstract String getCompliantPassword();

	@Override
	@Before
	public void setUp() {
		super.setUp();
		userManager.setPolicy(USERNAME, getPPolicy());
	}

	@Test
	public void aNewPasswordCompliantToThePolicyShouldBeAccepted() {
		assertTrue(userManager.changePassword(USERNAME, PASSWORD, getCompliantPassword()));
	}
}
