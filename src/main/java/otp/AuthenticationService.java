package otp;

public class AuthenticationService {

    private final IProfile profile;
    private final IToken token;

    public AuthenticationService(IProfile profile, IToken token) {
        this.profile = profile;
        this.token = token;
    }

    public AuthenticationService() {
        profile = new ProfileDao();
        token = new RsaTokenDao();
    }

    public boolean isValid(String account, String password) {
        String passwordFromDao = profile.getPassword(account);

        String randomCode = token.getRandom(account);

        String validPassword = passwordFromDao + randomCode;
        boolean isValid = password.equals(validPassword);

        if (isValid) {
            return true;
        } else {
            return false;
        }
    }
}
