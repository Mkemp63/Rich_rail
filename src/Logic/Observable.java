package Logic;

public interface Observable {
    void addObserver(Observer obs);

    void removeObserver(Observer obs);
}
