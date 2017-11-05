package pl.kodolamacz.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Room;

/**
 * Created by acacko on 29.10.17
 */
@Repository
public interface RoomDao extends JpaRepository<Room, Long> {

    Room findByCapacity(int number);

    Room findByNumber(int number);

}
