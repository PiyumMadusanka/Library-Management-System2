package Lbs;

public class UserProfile {

    Integer userId;
    String username, password, name, role, address, tpNo, nicNo, email;

    public UserProfile(Integer userId, String username, String password, String name, String role, String address, String tpNo, String nicNo, String email) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.address = address;
        this.tpNo = tpNo;
        this.nicNo = nicNo;
        this.email = email;

    }

}
