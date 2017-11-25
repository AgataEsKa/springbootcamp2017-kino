package pl.kodolamacz.spring.dao.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by acacko on 25.11.17
 */
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    private String role;

    public Role(String role) {
        this.role = role;
    }

    public Role() {}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
