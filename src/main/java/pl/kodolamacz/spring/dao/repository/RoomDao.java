package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Room;

/**
 * Created by acacko on 29.10.17
 */
public interface RoomDao extends AbstractDao<Room> {

    Room findByRoomNumber(int number);

}
