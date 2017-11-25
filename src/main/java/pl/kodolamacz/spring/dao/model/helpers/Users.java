package pl.kodolamacz.spring.dao.model.helpers;

import pl.kodolamacz.spring.dao.model.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by acacko on 25.11.17
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name = "user-list")
    private List<User> userList;

    public Users() {}

    public Users(List<User> users) {
        this.userList = users;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> users) {
        this.userList = users;
    }
}
