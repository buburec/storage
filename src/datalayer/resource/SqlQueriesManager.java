package datalayer.resource;

import java.util.ResourceBundle;

public class SqlQueriesManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.sql_queries");

    private SqlQueriesManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
