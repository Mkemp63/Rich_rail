package Domain;

import java.util.ArrayList;

public class Train {
	
	private String Name; 
	private ArrayList<Wagon> Wagons;
	
	public Train() {
		//hoi
	}
	
	public Train(String name) {
		Name = name;
		Wagons = new ArrayList<Wagon>();
	}
	
	public String getName() {
		return Name;
		
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public boolean removeWagon(Wagon wagon) {
		return Wagons.remove(wagon);
	}
	
	public ArrayList<Wagon> getWagons(){
		return Wagons;
	}
	
	public void setWagon(Wagon wagon) {
		Wagons.add(wagon);
	}


	public void addWagon(Wagon w) {
		Wagons.add(w);
	}
}
