package pl.kodolamacz.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.spring.dao.model.Reservation;
import pl.kodolamacz.spring.dao.repository.ReservationDao;
import pl.kodolamacz.spring.services.CinemaService;
import pl.kodolamacz.spring.services.exceptions.UserNotFoundException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by acacko on 25.11.17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class CinemaServiceMockTest {

    @Autowired
    @InjectMocks
    private CinemaService cinemaService;

    @Mock
    private ReservationDao reservationDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = UserNotFoundException.class)
    public void test() throws UserNotFoundException {
        cinemaService.checkUser("aaa", "sf");
    }

    @Test
    public void testWithMockito() throws UserNotFoundException {
        when(reservationDao.findByUserId(2L)).thenReturn(Collections.EMPTY_LIST);

        List<Reservation> reservationsByUserId = cinemaService.findReservationsByUserId(2L);
        assertThat(reservationsByUserId).isEmpty();

        verify(reservationDao, times(1)).findByUserId(any());

    }



}
