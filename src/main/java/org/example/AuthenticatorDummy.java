package org.example;

// Dummy - do Nothing, return degenerate values
public class AuthenticatorDummy implements Authenticator{

    @Override
    public Boolean authenticate(String username, String password) {
        return null;
    }
}
