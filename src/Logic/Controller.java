package Logic;


import Domain.Train;
import Domain.Wagon;
import java.util.ArrayList;
import java.util.Iterator;

public class Controller implements Observable {
	public ArrayList<Train> trains = new ArrayList<Train>();
	public ArrayList<Wagon> wagons = new ArrayList<Wagon>();
	public ArrayList<Observer> observers = new ArrayList<Observer>();
	private static Controller instance;
	
	public boolean trainExists(String nm) {
		for (Train t : trains) {
			if (t.getName().equals(nm)){
				return true;
			}
		} return false;
	}
	
	public boolean wagonExists(int id) {
		ArrayList<Wagon> Wagons = wagons;
		for(Wagon w: Wagons) {
			if(w.getID()==id) {
				return true;
			}
		 } return false;
	}
	
	public boolean wagonUsed(Wagon wagon) {
		ArrayList<Wagon> Wagons = null;
		for(Train t : trains) {
			Wagons = t.getWagons();
			for(Wagon w : Wagons) {
				if(w.equals(wagon)) {
					return true;
				}
			}
		} return false;
	}
	
	public void connectWagon(int wagon, String train) {
		
		if(trainExists(train)) {
			//TODO: implement
		}
		
		if(wagonExists(wagon)) {
			//TODO: implement
		}
		
	}
	
	public void disconnectWagon(int wagon, String train) {
		if(trainExists(train)) {
			//TODO: implement
		}
		
		if(wagonExists(wagon)) {
			//TODO: implement
		}
	}
	
	public void addTrain(String name) {
		//TODO: implement
	}
	
	public void addWagon(int id, int seats) {
			//TODO: implement
	}
	
	public void deleteTrain(String train) {
		if(trainExists(train)) {
			//TODO: implement
		}
	}
	
	public void deleteWagon(int id) {
		if(wagonExists(id)) {
			//TODO: implement
		}
	}
	
	public void getTrainSeats(String train) {
		if(trainExists(train)) {
			//TODO: implement
		}
	}
	
	public void getWagonSeats(int id) {
		if(wagonExists(id)) {
			//TODO: implement
		}
	}
	
	public static Controller getInstance(){
		if(instance == null)
			instance = new Controller();
		return instance;
	}
	
	public void addObserver(Observer obs) {
		observers.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}
	
	
}
