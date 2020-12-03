package login;

import java.util.ArrayList;

public class LoginModel {
    //list of all users
    public static ArrayList<User> userDatabase = new ArrayList<>();

    public String validateLogin(String userName, String password) {
        for (User user : userDatabase) {
            //checks if the userName exists in the database
            if(user.getUserName().equals(userName)) {
                //checks if the entered password equals the one from the user
                if(user.getPassword().equals(password)) {
                    return "Correct login.";
                } else {
                    return "Incorrect password. Please try again.";
                }
            }
        }
        return "User doesn't exist.";
    }

    /**
     *
     * @param newUser
     */
    public static void signUp(User newUser) {
        userDatabase.add(newUser);
    }
}