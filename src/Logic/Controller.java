package Logic;


import Domain.Train;
import Domain.Wagon;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller implements Observable {
    private ArrayList<String> logs = new ArrayList<>();
    private ArrayList<Train> trains = new ArrayList<>();
    private ArrayList<Wagon> wagons = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();
    private static Controller instance;

    public boolean trainExists(String nm) {
        for (Train t : trains) {
            if (t.getName().equals(nm)) {
                return true;
            }
        }
        return false;
    }

    public boolean wagonExists(int id) {
        ArrayList<Wagon> Wagons = wagons;
        for (Wagon w : Wagons) {
            if (w.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean wagonUsed(Wagon wagon) {
        ArrayList<Wagon> Wagons = null;
        for (Train t : trains) {
            Wagons = t.getWagons();
            for (Wagon w : Wagons) {
                if (w.equals(wagon)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void connectWagon(int wagon, String train) {

        if (!trainExists(train)) {
            logs.add("Train doesn\'t exist");

        }

        if (!wagonExists(wagon)) {
            logs.add("Wagon doesn\'t exist");

        }
        for (Train t : trains) {
            if (t.getName().equals(train)) {
                for (Wagon w : wagons) {
                    if (w.getID() == wagon) {
                        if (wagonUsed(w)) {
                            //TODO: get access to addWagon
                            t.addWagon(w);
                            logs.add(wagon + " connected to " + train);
                        }
                    }
                }
            }
        }
    }

    public void disconnectWagon(int wagon, String train) {
        boolean connected = false;
        if (!trainExists(train)) {
            logs.add("Train doesn\'t exist");

        }

        if (!wagonExists(wagon)) {
            logs.add("wagon doesn\'t exist");

        }
        for (Train t : trains) {
            if (t.getName().equals(train)) {
                ArrayList<Wagon> wagons = t.getWagons();
                for (Wagon w : wagons) {
                    if (w.getID() == wagon) {
                        connected = true;
                        t.removeWagon(w);
                        logs.add(wagon + " disconnected from " + train);
                    }
                }
            }
        }
        if(!connected){

        }
    }

    public void addTrain(String name) {
        //TODO: implement
    }

    public void addWagon(int id, int seats) {
        int a = 1;

    }

    public void deleteTrain(String train) {
        if (trainExists(train)) {
            //TODO: implement
        }
    }

    public void deleteWagon(int id) {
        if (wagonExists(id)) {
            //TODO: implement
        }
    }

    public void getTrainSeats(String train) {
        if (trainExists(train)) {
            //TODO: implement
        }
    }

    public void getWagonSeats(int id) {
        if (wagonExists(id)) {
            //TODO: implement
        }
    }

    public static Controller getInstance() {
        if (instance == null)
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
