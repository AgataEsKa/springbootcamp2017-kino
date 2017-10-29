package pl.kodolamacz.spring.dao.model;

import java.util.Date;

/**
 * Created by acacko on 29.10.17
 */
public class Show extends Entity {

    private Date date;

    private Movie movie;
    private Room room;

    public Show(Long id, Date date, Movie movie, Room room) {
        super(id);
        this.date = date;
        this.movie = movie;
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
