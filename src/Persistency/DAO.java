package Persistency;

import java.util.List;

public interface DAO<T> {

    void add(T t);

    void remove(T t);

    void update(T t);

}
