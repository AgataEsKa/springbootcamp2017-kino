package pl.kodolamacz.spring.dao.model;

import java.util.List;

/**
 * Created by acacko on 29.10.17
 */
public class Room extends Entity {

    private int number;
    private int capacity;

    public Room(Long id, int number, int capacity) {
        super(id);
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
