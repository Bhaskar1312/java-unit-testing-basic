import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    boolean CLOSE = true;
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

    @Test
    public void authenticatorCallValidated() throws Exception {
        AuthenticatorMock mock = new AuthenticatorMock("Bob", "xyzw", 1);
        LoginPage page = new LoginPage(mock);
        mock.setResult(true);
        page.show();
        boolean success = page.submit("Bob", "xyzw");
        assertTrue(success);
        assertTrue(mock.validate());
    }

    @Test
    public void authenticatorFakePassForCertainValues() {
        Authenticator fake = new AuthenticatorFake();
        LoginPage page = new LoginPage(fake);
        page.show();
        boolean success = page.submit("uncleBob", "qwerty123");
        assertTrue(success);
    }

}
