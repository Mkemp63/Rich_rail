package Persistency;

import Domain.Train;

import java.util.ArrayList;
import java.util.List;

public class TreinDAO implements DAO<Train> {
    private List<Train> trains = new ArrayList<>();

    @Override
    public void add(Train train) {
        trains.add(train);
    }

    @Override
    public void remove(Train train) {
        trains.remove(train);
    }

    @Override
    public void update(Train train) {
        train.setName(train.getName());
    }

}
