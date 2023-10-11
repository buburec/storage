package controller;

import java.util.ResourceBundle;

// import com.prutzkow.resourcer.*;

public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");
    // private final static Resourcer resourcer = ProjectResourcer.getInstance();

    // класс извлекает информацию из файла config.properties
    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
