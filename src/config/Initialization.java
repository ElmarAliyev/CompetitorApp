package config;

import bean.User;
import util.FileUtil;

public class Initialization {
    public static Config config = null;

    public static void initializeConfig(User user) {
        config = new Config(user);
        try {
            Object configObj = FileUtil.readObjectFromFile("config.ser");
            config = (Config) configObj;
        } catch (Exception e) {
            //Ignore
//            e.printStackTrace();
        }
    }

    public static void refreshConfig() {  //  tightly coupling
        FileUtil.writeObjectToFile(config, "config.ser");
    }
}
