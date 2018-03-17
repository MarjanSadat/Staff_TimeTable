package ir.marjan.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIMETABLES")
public class TimeTable {

    @Id
    @SequenceGenerator(name = "MY_SEQ",sequenceName = "TIMETABLE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MY_SEQ")
    private long id;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENTRY")
    private Date entry;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXIT")
    private Date exit;

    @ManyToOne (cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private User user;

    public TimeTable(Date entry, Date exit, User user) {
        this.entry = entry;
        this.exit = exit;
        this.user = user;
    }

    public TimeTable() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", entry=" + entry +
                ", exit=" + exit +
                '}';
    }
}
