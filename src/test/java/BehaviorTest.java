import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class BehaviorTest {

    @Test
    public void credentialsShouldBeNullIfNoServiceName() throws Exception {
        NegotiateAuthenticator authenticator = new NegotiateAuthenticator(manager, properties);
        assertNull(authenticator.getSerrverCredentials());
        verify(manager, never()).createName(anyString(), (Oid)anyObject, (Oid)anyObject);
    }
}
