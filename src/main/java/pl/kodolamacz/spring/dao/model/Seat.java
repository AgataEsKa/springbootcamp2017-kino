package pl.kodolamacz.spring.dao.model;

/**
 * Created by acacko on 29.10.17
 */
public class Seat extends Entity {

    private int number;

    public Seat(Long id, int number) {
        super(id);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
