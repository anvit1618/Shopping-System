package auth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AuthServiceTest {

    @Test
    public void testLoginSuccess() {
        AuthService authService = AuthService.getInstance();
        User newUser = new User("user1", "password1");
        authService.register(newUser);
        User user = authService.login("user1", "password1");
        assertNotNull(user);
        assertEquals("user1", user.getUsername());
    }

    @Test
    public void testLoginFailure() {
        AuthService authService = AuthService.getInstance();
        User user = authService.login("nonexistent", "wrongpassword");
        assertNull(user);
    }

    @Test
    public void testRegister() {
        AuthService authService = AuthService.getInstance();
        User newUser = new User("newUser", "newPassword");
        authService.register(newUser);
        User registeredUser = authService.login("newUser", "newPassword");
        assertNotNull(registeredUser);
        assertEquals("newUser", registeredUser.getUsername());
    }
}
