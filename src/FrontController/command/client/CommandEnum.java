package FrontController.command.client;

import FrontController.command.*;

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
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
