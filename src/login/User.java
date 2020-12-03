package login;

public class User {
    //user attributes
    private String userName;
    private String password;

    //constructor
    public User() {

    }

    //creates user with an username and password
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //getter and setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
