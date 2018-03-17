package ir.marjan.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "MY_SEQ", sequenceName = "USERS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_SEQ")
    private long id;

    @Basic
    @Column(name = "FIRSTNAME", columnDefinition = "NVARCHAR2(20)")
    private String firstname;

    @Basic
    @Column(name = "LASTNAME", columnDefinition = "NVARCHAR2(20)")
    private String lastname;

    @Basic
    @Column(name = "USERNAME", columnDefinition = "VARCHAR2(20)")
    private String username;

    @Basic
    @Column(name = "PASSWORD", columnDefinition = "VARCHAR2(20)")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private List<TimeTable> timeTableTOS;

    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.timeTableTOS = new ArrayList<>();
    }

    public User() {
        this.timeTableTOS = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TimeTable> getTimeTableTOS() {
        return timeTableTOS;
    }

    public void setTimeTableTOS(List<TimeTable> timeTableTOS) {
        this.timeTableTOS = timeTableTOS;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", timeTableTOS=" + timeTableTOS +
                '}';
    }
}
