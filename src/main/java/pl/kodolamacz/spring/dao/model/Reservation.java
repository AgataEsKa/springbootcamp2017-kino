package pl.kodolamacz.spring.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.kodolamacz.spring.dao.model.helpers.Status;

import javax.persistence.*;

/**
 * Created by acacko on 29.10.17
 */
@Entity
@Table(name = "reservations")
public class Reservation extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private Status status = Status.WAITING;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private Show show;

    public Reservation() {}

    public Reservation(User user, Show show) {
        this.user = user;
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "status=" + status +
                ", user=" + user +
                ", show=" + show +
                '}';
    }
}
