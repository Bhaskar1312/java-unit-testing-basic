package org.example;

// Stub, A dummy that returns test specific values
public class RejectingAuthenticatorStub implements Authenticator{
    @Override
    public Boolean authenticate(String username, String password) {
        return false;
    }
}
