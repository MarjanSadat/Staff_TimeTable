package ir.marjan.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @SequenceGenerator(name = "MY_SEQ",sequenceName = "ROLES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MY_SEQ")
    private long id;

    @Basic
    @Column(name = "USERNAME",columnDefinition = "VARCHAR2(20)")
    private String username;

    @Basic
    @Column(name = "PERMISSION",columnDefinition = "VARCHAR2(20)")
    private String permission;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
