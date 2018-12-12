package Logic;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Logger implements Observer{
	private ArrayList<String> log = new ArrayList<String>();
	private static Logger instance;
	private Controller cont = Controller.getInstance();

	public Logger(){
		cont.addObserver(this);
	}
	public void update(Observable O) {
		//TODO: implement
	}

	public void Write(String input){
		String logs = System.getProperty("user.dir")+"Richlog.log";
		try{
			BufferedWriter wr = new BufferedWriter(new FileWriter(logs, true));
			wr.append(input);
			wr.newLine();
			wr.close();
		} catch (IOException e){
			e.printStackTrace();
		}

	}
}
