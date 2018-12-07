package Domain;


public class Wagon {
	private int Seats;
	private int ID;
	
	public Wagon(int id, int seats) {
		id = ID;
		seats = Seats;
	}
	
	public int getSeat() {
		return Seats;
	}
	
	public void setSeats(int seats) {
		Seats = seats;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		ID = id;
	}
}