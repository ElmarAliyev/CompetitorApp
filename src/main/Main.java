package main;

import bean.User;
import config.Initialization;
import util.MenuUtil;
import util.UserUtil;

public class Main {

    public static void main(String[] args) {
        /*
        User: Elmar
        Login: 12345
         */
        User user = UserUtil.requiredInputsAndLogin(3, true);
        Initialization.initializeConfig(user);
        System.out.println("Heloo, " + user.getUsername());
        MenuUtil.showMenuInfinite();
    }
}
