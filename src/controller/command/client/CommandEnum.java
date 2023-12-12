package controller.command.client;

import controller.command.*;
import controller.command.administrator.*;
import controller.command.driver.*;
import controller.command.moderator.BlockUserCommand;
import controller.command.moderator.CreateProductCommand;
import controller.command.moderator.DeleteProductCommand;
import controller.command.moderator.ProductListCommand;
import controller.command.storekeeper.*;

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
    CHOOSE_REQUEST {
        {
            this.command = new ChooseRequestCommand();
        }
    },
    PRODUCT_LIST {
        {
            this.command = new ProductListCommand();
        }
    },
    CREATE_PRODUCT {
        {
            this.command = new CreateProductCommand();
        }
    },
    CREATE_REQUEST {
        {
            this.command = new CreateRequestCommand();
        }
    },
    FILL_REQUEST {
        {
            this.command = new FillRequestCommand();
        }
    },
    ADD_WAYBILL_PRODUCT {
        {
            this.command = new AddWaybillProductCommand();
        }
    },
    DELETE_WAYBILL_PRODUCT {
        {
            this.command = new DeleteWaybillProductCommand();
        }
    },
    CREATE_TRUCK {
        {
            this.command = new CreateTruckCommand();
        }
    },
    DRIVER_PROFILE {
        {
            this.command = new DriverProfileCommand();
        }
    },
    UPDATE_DRIVER_PROFILE {
        {
            this.command = new UpdateDriverProfileCommand();
        }
    },
    STOREKEEPER_REQUESTS {
        {
            this.command = new StorekeeperRequestsCommand();
        }
    },
    DRIVER_REQUEST {
        {
            this.command = new DriverRequestCommand();
        }
    },
    DELETE_REQUEST {
        {
            this.command = new DeleteRequestCommand();
        }
    },
    STOREKEEPER_TRUCK_LIST {
        {
            this.command = new StorekeeperTruckListCommand();
        }
    },
    BLOCK_USER {
        {
            this.command = new BlockUserCommand();
        }
    },
    ACCEPT_REQUEST {
        {
           this.command = new AcceptRequestCommand();
        }
    },
    DECLINE_REQUEST {
        {
            this.command = new DeclineRequestCommand();
        }
    },
    REQUEST_RESPONSE {
        {
            this.command = new RequestResponseCommand();
        }
    },
    STOREKEEPER_REQUEST {
        {
            this.command = new StorekeeperRequestCommand();
        }
    },
    DRIVER_RETURN_WAYBILL {
        {
            this.command = new DriverReturnWaybillCommand();
        }
    },
    DELETE_PRODUCT {
        {
            this.command = new DeleteProductCommand();
        }
    },
    DELETE_TRUCK {
        {
            this.command = new DeleteTruckCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
