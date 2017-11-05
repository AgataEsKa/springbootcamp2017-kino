package pl.kodolamacz.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by acacko on 29.10.17
 */

@Component
public class Application {

    @Value("${app.name:defaultValue}") // #{} - SpEL, ${} - propertisy
    private String appName;

    @Value("${app.version}")
    private int version;

    // wywołanie metody/konstruktora na dowolnym obiekcie
    @Value("#{new java.util.Date()}")
    private Date date;


    // wywołanie metody na bean'ie
    @Value("#{idSequenceGenerator.version}")
    private int generatorVersion;

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

        User user = userDao.findByEmail("arek@cacko.pl");
        System.out.println("Odczytano z bazy: " + user);

        System.out.println("Odczytano z bazy wszystkie: " + userDao.findAll());

        User arek = new User("cacko@arek.pl", "pass");
//        userDao.save(arek);

        Movie titanic = new Movie("Titanic2", 2000);
//        movieDao.save(titanic);

        Room room = new Room(3, 50);
//        roomDao.save(room);

        Show show = new Show(Calendar.getInstance().getTime(), titanic, room);
//        Show showFromDatabase = showDao.save(show);

        Reservation reservation = new Reservation(arek, show);
        reservationDao.save(reservation);
//
//        // ---------------------
//
//        Reservation reservationDaoById = reservationDao.findOne(reservation.getId());
//        System.out.println(reservation);
//
        System.out.println("Spring data room test: " + roomDao.findByCapacity(250));
        System.out.println("Spring data custom method: " + userDao.findByPaaasword("myPassword"));


    }
}
