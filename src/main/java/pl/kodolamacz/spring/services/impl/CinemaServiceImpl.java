package pl.kodolamacz.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.*;
import pl.kodolamacz.spring.services.CinemaSerice;
import pl.kodolamacz.spring.services.exceptions.UserNotFoundException;

import java.util.Date;

/**
 * Created by acacko on 04.11.17
 */
@Repository
public class CinemaServiceImpl implements CinemaSerice {

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


    @Override
    public void createUser(String email, String password) {
        userDao.save(new User(email, password));
        // tutaj ewentualny kod w przyszłości
    }

    @Override
    public boolean checkUser(String email, String password) throws UserNotFoundException {
        User user = userDao.findUser(email);
        if(user == null)
            throw new UserNotFoundException("user not found with email: "+ email);

        return user.getPassword().equals(password);
    }


    @Override
    public void createShow(Date date, String movieTitle, int roomNumber) {
        Movie movie = movieDao.findByTitle(movieTitle);
        Room room = roomDao.findByRoomNumber(roomNumber);
        showDao.save(new Show(date, movie, room));
    }

    @Override
    public void createReservation(User user, Show show) {
        reservationDao.save(new Reservation(user, show));
    }

    @Override
    public void createMovie(String title, int price) {
        movieDao.save(new Movie(title, price));
    }
}
