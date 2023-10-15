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
    WELCOME {
        {
            this.command = new WelcomeCommand();
        }
    },
    USER_LIST{
        {
            this.command = new UserListCommand();
        }
    },
    PROFILE{
        {
            this.command = new ProfileCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
