package Domain;


public class Wagon {
    private int Seats;
    private int ID;

    public Wagon(int id, int seats) {
        ID = id;
        Seats = seats;
    }

    public int getSeats() {
        return Seats;
    }


    public int getID() {
        return ID;
    }

    public void setID(int id) {
        ID = id;
    }
}