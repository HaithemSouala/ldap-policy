package fr.gfi.ldappolicy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author hsouala
 */
public class WhenAUserAttemptsToLogIn extends AppTestCase {
                
    @Test
    public void aValidUserShouldBeAbleToLogIn() {
        assertTrue(userManager.login(USERNAME, PASSWORD));
    }
    
    @Test
    public void anInvalidPasswordShouldNotBeAccepted() {
        assertFalse(userManager.login(USERNAME, "nonsense"));
    }
    
    @Test
    public void anInvalidUsernameShouldNotBeAccepted() {
        assertFalse(userManager.login("nonsense", PASSWORD));
    }    
    
}
