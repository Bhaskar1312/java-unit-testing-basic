import org.example.AuthenticatorDummy;
import org.example.AuthenticatorSpy;
import org.example.PromiscuousAuthenticatorStub;
import org.example.RejectingAuthenticatorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void cancelLoginPage() throws Exception {
        LoginPage page = new LoginPage(new AuthenticatorDummy());
        page.show();
        boolean success = page.sendEvent(CLOSE);
        assertTrue(success);
    }

    @Test
    public void canLogin() throws Exception {
        LoginPage page = new LoginPage(new PromiscuousAuthenticatorStub());
        page.show();
        boolean success = page.submit("some user name", "some password");
        assertTrue(success);
    }

    @Test
    public void failsLogin() throws Exception {
        LoginPage page = new LoginPage(new RejectingAuthenticatorStub());
        page.show();
        boolean success = page.submit("some user name", "some password");
        assertFalse(success);
    }

    @Test
    public void authenticatorCalledCorrectly() throws Exception {
        AuthenticatorSpy spy = new AuthenticatorSpy();
        LoginPage page = new LoginPage(spy);
        spy.setResult(true);
        page.show();
        boolean success = page.submit("user", "pw");
        assertTrue(success);
        assertEquals(1, spy.getCount());
        assertEquals("user", spy.getLastUserName());
        assertEquals("pw", spy.getLastPassword());
    }

}
