package org.example;

public class AuthenticatorFake implements Authenticator {
    @Override
    public Boolean authenticate(String username, String password) {
        return username.equals("uncleBob") && password.equals("qwerty123");
    }
}
