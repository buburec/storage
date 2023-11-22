package controller.command.client;

import controller.command.*;
import controller.command.administrator.*;
import controller.command.driver.*;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    FORWARD {
        {
            this.command = new ForwardCommand();
        }
    },
    USERS {
        {
            this.command = new UsersCommand();
        }
    },
    EDIT_USER {
        {
            this.command = new EditUserCommand();
        }
    },
    DRIVER_REQUESTS {
        {
            this.command = new DriverRequestsCommand();
        }
    },
    OCCUPATIONS {
        {
            this.command = new OccupationsCommand();
        }
    },
    PROFILE {
        {
            this.command = new ProfileCommand();
        }
    },
    UPDATE_PROFILE {
        {
            this.command = new UpdateProfileCommand();
        }
    },
    CREATE_USER {
        {
            this.command = new CreateUserCommand();
        }
    },
    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
        }
    },
    DRIVER_PRODUCT_LIST {
        {
            this.command = new DriverProductListCommand();
        }
    },
    ENTRY_REQUEST {
        {
            this.command = new EntryRequestCommand();
        }
    },
    CREATE_DRIVER_REQUEST {
        {
            this.command = new CreateDriverRequestCommand();
        }
    },
    EXIT_REQUEST {
        {
            this.command = new ExitRequestCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
