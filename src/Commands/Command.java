package Commands;

import Logic.Controller;

public abstract class Command {

    Controller cont = Controller.getInstance();

    public abstract void useCommand(String input);
}
