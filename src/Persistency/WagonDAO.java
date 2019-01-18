package Persistency;

import Domain.Wagon;

import java.util.ArrayList;
import java.util.List;

public class WagonDAO implements DAO<Wagon> {
    private List<Wagon> wagons = new ArrayList<>();

    @Override
    public void add(Wagon wagon) {
        wagons.add(wagon);
    }

    @Override
    public void remove(Wagon wagon) {
        wagons.remove(wagon);
    }

    @Override
    public void update(Wagon wagon) {
        wagon.setID(wagon.getID());
    }


}
