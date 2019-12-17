package util;

import bean.User;

import java.util.Scanner;

public class UserUtil {

    public static User login(String username, String password) {
        if ("Elmar".equalsIgnoreCase(username) && "12345".equalsIgnoreCase(password)) {
            User user = new User(username, password);
            return user;
        }
        throw new IllegalArgumentException("Username or Password is incorrect");
    }

    public static User requiredInputsAndLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type your username:");
        String username = sc.nextLine();
        System.out.println("Please type your password:");
        String password = sc.nextLine();
        User user = UserUtil.login(username, password);
        return user;
    }

    public static User requiredInputsAndLogin(int tryCount, boolean throwException) {
        for (int i = 0; i < tryCount; i++) {
            try {
                User user = requiredInputsAndLogin();
                return user;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again");
            }
        }
        if (throwException)
            throw new IllegalArgumentException("You have banned!");
        else
            return null;
    }
}
