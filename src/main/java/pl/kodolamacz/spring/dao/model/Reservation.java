package pl.kodolamacz.spring.dao.model;

import pl.kodolamacz.spring.dao.model.helpers.Status;

/**
 * Created by acacko on 29.10.17
 */
public class Reservation extends Entity {

    private Status status = Status.WAITING;

    private User user;
    private Show show;

    public Reservation(Long id, User user, Show show) {
        super(id);
        this.user = user;
        this.show = show;
    }
}
