package controller.logic;

import java.util.HashMap;

public class CreateUserLogic {
    private static final HashMap<String, Integer> roleMap = new HashMap<>();

    static {
        roleMap.put("Administrator", 0);
        roleMap.put("Moderator", 1);
        roleMap.put("Driver", 2);
        roleMap.put("Storekeeper", 3);
    }

    public static int getOccupationIdentifier(String title) {
        return roleMap.getOrDefault(title, -1);
    }

}
