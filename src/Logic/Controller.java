package Logic;
//todo

import Domain.Train;
import Domain.Wagon;

import java.util.ArrayList;

public class Controller implements Observable {
    private static Controller instance;
    private ArrayList<String> logs = new ArrayList<>();
    public ArrayList<Train> trains = new ArrayList<>();
    public ArrayList<Wagon> wagons = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

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
        ArrayList<Wagon> Wagons;
        for (Train t : trains) {
            Wagons = t.getWagons();
            for (Wagon w : Wagons) {
                if (w.equals(wagon)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void connectWagon(int wagon, String train) {
        System.out.println("Check Train: "+ train + " Wagon: " + wagon);

        if (!trainExists(train)) {
            logs.add("Train doesn\'t exist");
            System.out.println("Train doesn\'t exist");
            observe();

        }

        if (!wagonExists(wagon)) {
            logs.add("Wagon doesn\'t exist");
            System.out.println("Wagon doesn\'t exist");
            observe();
        }
        for (Train t : trains) {
            if (t.getName().equals(train)) {
                for (Wagon w : wagons) {
                    if (w.getID() == wagon) {
                        if (wagonUsed(w)) {
                            System.out.println("test");
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
            observe();

        }

        if (!wagonExists(wagon)) {
            logs.add("wagon doesn\'t exist");
            observe();

        }
        for (Train t : trains) {
            if (t.getName().equals(train)) {
                ArrayList<Wagon> wagons = t.getWagons();
                for (Wagon w : wagons) {
                    if (w.getID() == wagon) {
                        connected = true;
                        t.removeWagon(w);
                        logs.add(wagon + " disconnected from " + train);
                        observe();
                    }
                }
            }
        }
        if (!connected) {
            logs.add("Wagon "+wagon+" not unlinked from train "+ train);
            observe();
        }
    }

    public ArrayList<String> getLogs() {
        return logs;
    }

    public void addTrain(String name) {
        if (!trainExists(name)) {
            Train t = new Train(name);
            trains.add(t);
            logs.add("Train " + name + " added");
            System.out.println("Train " + name + " added");
            observe();

        }
    }

    public void addWagon(int id, int seats) {
        boolean wagon = true;
        boolean wagonID = false;
        for (Wagon w : wagons) {
            if (id == w.getID()) {
                wagonID = true;
                System.out.println("Wagon ID not unique");
            }
        }
        if (!wagonID) {
            wagon = false;
            Wagon w = new Wagon(id, seats);
            wagons.add(w);
            System.out.println("Wagon " + id + " with " + seats + " seats");
            logs.add("Wagon " + id + " with " + seats + " seats");
            observe();
        }

        if (wagon) {
            logs.add("Wagon already exists");
        }

    }

    public void deleteTrain(String train) {
        if (!trainExists(train)) {
            System.out.println("No such train");
            logs.add("No such train");
            observe();
        } else {
            Train t = new Train();
            for (Train tr : trains) {
                if (tr.getName().equals(train)) {
                    t = tr;
                }
            }
            logs.add(train + " has been deleted from trains");
            System.out.println(train + " has been deleted from trains");
            trains.remove(t);
            observe();
        }
    }

    public void deleteWagon(int id) {
        if (!wagonExists(id)) {
            System.out.println("No such wagon");
            logs.add("No such wagon");
            observe();
        } else {
            for (Wagon w : wagons) {
                if (w.getID() == id) {
                    wagons.remove(w);
                    for (Train tr : trains) {
                        tr.removeWagon(w);
                        logs.add(id + " has been remobed from wagons");
                        System.out.println(id + " has been remobed from wagons");
                        observe();
                    }
                }
            }
        }
    }



    public void getWagonSeats(int idWagon) {
        if (wagonExists(idWagon)) {
            observe();
            logs.add("no such wagon");
            System.out.println("No such wagon");


        }
        ArrayList<Wagon> Wagonlist = wagons;
        for (Wagon w : Wagonlist) {
            if (w.getID() == idWagon) {
                observe();
                logs.add("Wagon " + idWagon + " has " + w.getSeats() + " seats");
                System.out.println("Wagon " + idWagon + " has " + w.getSeats() + " seats");
            }
        }
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    public void observe() {
        if (observers.size() == 0) {
            System.out.println("No observers to notify");
        } else {
            for (Observer obs : observers) {
                obs.update(this);
                System.out.println("notified observers");

            }
        }
    }

    public void getSeats(String name) {
        if (!trainExists(name)) {
            observe();
            logs.add("No such train");
            System.out.println("No such train");
        } else {
            int seats = 0 ;
            ArrayList<Wagon> WagonList = null;
            ArrayList<Train> TrainList = trains;
            for(Train tr: TrainList){
                if(tr.getName().equals(name)){
                    WagonList = tr.getWagons();
                }
            }
            for(Wagon w: WagonList){
                seats += w.getSeats();
            }
            logs.add("Train "+ name + " has "+seats+" seats");
            System.out.println("Train "+ name + " has "+seats+" seats");
            observe();
        }
    }

    public int getIByID (int id) {
        for (Wagon w : wagons) {
            int wagonID = w.getID();
            if (wagonID == id) {
                return wagonID;
            }
        }
        return -1;
    }



}
