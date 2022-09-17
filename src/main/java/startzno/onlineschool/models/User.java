package startzno.onlineschool.models;

import javax.persistence.*;

/**
 * Simple JavaBean object that represents a User.
 *
 * @author Denys Shkolenko
 * @version 1.0
 */
@Entity
@Table(name = "users_table")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String userPassword;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
