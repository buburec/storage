package controller.logic;

public enum CreateUserEnumLogic {
    ADMINISTRATOR {
        {
            this.occupationIdentifier = 0;
        }
    },
    MODERATOR {
        {
            this.occupationIdentifier = 1;
        }
    },
    DRIVER {
        {
            this.occupationIdentifier = 2;
        }
    },
    STOREKEEPER {
        {
            this.occupationIdentifier = 3;
        }
    };

    int occupationIdentifier;

    public int getOccupationIdentifier() {
        return this.occupationIdentifier;
    }

}
