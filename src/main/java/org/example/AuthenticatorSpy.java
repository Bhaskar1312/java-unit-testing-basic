package org.example;

// Spy - Stub that remembers facts about the method calls
public class AuthenticatorSpy implements Authenticator{
    private Boolean result = null;
    private int count = 1;
    private String lastUserName;
    private String lastPassword;

    public int getCount() {
        return count;
    }

    public String getLastUserName() {
        return lastUserName;
    }

    public String getLastPassword() {
        return lastPassword;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public Boolean authenticate(String username, String password) {
        count++;
        lastUserName = username;
        lastPassword = password;
        return result;
    }
}
