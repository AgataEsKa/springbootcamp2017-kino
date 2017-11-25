package pl.kodolamacz.spring.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.*;
import pl.kodolamacz.spring.services.CinemaService;
import pl.kodolamacz.spring.services.exceptions.UserNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * Created by acacko on 04.11.17
 */
@Service
//@Transactional
public class CinemaServiceImpl implements CinemaService {

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
        User user = userDao.findByEmail(email);
        if(user == null)
            throw new UserNotFoundException("user not found with email: "+ email);

        return user.getPassword().equals(DigestUtils.md5Hex(password));
    }


    @Override
    public void createShow(Date date, String movieTitle, int roomNumber) {
        Movie movie = movieDao.findByTitle(movieTitle);
        Room room = roomDao.findByCapacity(roomNumber);
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

    @Override
    public List<Reservation> findReservationsByUserId(Long id) {
        return reservationDao.findByUserId(id);
    }
}
