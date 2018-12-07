package Commands;

import Logic.Controller;

public abstract class Command {
	
	public Controller cont = Controller.getInstance();
	
	public abstract void useCommand(String input);
}
