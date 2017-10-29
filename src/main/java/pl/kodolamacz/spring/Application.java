package pl.kodolamacz.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.*;

import java.util.Calendar;

/**
 * Created by acacko on 29.10.17
 */


public class Application {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private ShowDao showDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private ReservationDao reservationDao;

    public void simulate() {

        User arek = new User("cacko@arek.pl", "pass");
        userDao.save(arek);

        Movie titanic = new Movie("Titanic", 2000);
        movieDao.save(titanic);

        Room room = new Room(1, 50);
        roomDao.save(room);

        Show show = new Show(Calendar.getInstance().getTime(),titanic, room);
        showDao.save(show);

        Reservation reservation = new Reservation(arek, show);
        reservationDao.save(reservation);

        // ---------------------

        Reservation reservationDaoById = reservationDao.findById(reservation.getId());
        System.out.println(reservation);

    }
}
