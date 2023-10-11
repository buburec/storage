package FrontController.command.client;

import FrontController.command.ActionCommand;
import FrontController.command.LoginCommand;
import FrontController.command.LogoutCommand;

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
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
