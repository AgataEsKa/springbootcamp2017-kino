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
}
