package login;

import java.util.ArrayList;

public class LoginModel {
    //user attributes
    String userName = "Nevena";
    String password = "cisco cisco";

    public boolean isCorrectLogin(String userName, String password) {
        return userName.equals(this.userName) && password.equals(this.password);
    }
}