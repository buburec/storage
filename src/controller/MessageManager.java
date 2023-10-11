package controller;

import java.util.ResourceBundle;

// import com.prutzkow.resourcer.*;

// import com.prutzkow.resourcer.*;

public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");
    // private final static Resourcer resourcer = ProjectResourcer.getInstance();

    // класс извлекает информацию из файла messages.properties
    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}

