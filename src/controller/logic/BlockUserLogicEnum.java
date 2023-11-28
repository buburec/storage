package controller.logic;

public enum BlockUserLogicEnum {
    BLOCKED {
        {
            this.status = "offline";
        }
    },
    ONLINE {
        {
            this.status = "blocked";
        }
    },
    OFFLINE {
        {
            this.status = "blocked";
        }
    };

    String status;

    private String getStatus() {
        return this.status;
    }

    public static String changeUserStatus(String currentStatus) {
        return BlockUserLogicEnum.valueOf(currentStatus.toUpperCase()).getStatus();
    }
}
