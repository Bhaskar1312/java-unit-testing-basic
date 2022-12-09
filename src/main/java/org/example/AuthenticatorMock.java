package org.example;

// Mock - A Spy that knows how methods should be called
public class AuthenticatorMock extends AuthenticatorSpy {
    private String expectedUserName;
    private String expectedPassword;
    private int expectedCount;

    public AuthenticatorMock(String expectedUserName, String expectedPassword, int expectedCount) {
        this.expectedCount = expectedCount;
        this.expectedUserName = expectedUserName;
        this.expectedPassword = expectedPassword;
    }

    public boolean validate() {
        return getCount() == expectedCount &&
                getLastUserName().equals(expectedUserName) &&
                getLastPassword().equals(expectedPassword);
    }
}
