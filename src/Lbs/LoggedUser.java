package Lbs;

public class LoggedUser {

    private static UserProfile loginUser;

    public UserProfile getLoginUser() {
        return LoggedUser.loginUser;
    }

    public void setLoginUser(UserProfile loginUser) {
        LoggedUser.loginUser = loginUser;
    }

}
