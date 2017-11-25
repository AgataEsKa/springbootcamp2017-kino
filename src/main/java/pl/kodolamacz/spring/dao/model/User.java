package pl.kodolamacz.spring.dao.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by acacko on 29.10.17
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.byMail",
            query = "select a from User a where a.email = :email"
    )
})
//@XmlRootElement(name = "user")
public class User extends AbstractEntity {

    private String email;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservation> reservations;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles = new HashSet<>();

    // for hibernate:
    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Long id, String email, String password) {
        super(id);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setRole(Role role) {
        roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + getId() +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
