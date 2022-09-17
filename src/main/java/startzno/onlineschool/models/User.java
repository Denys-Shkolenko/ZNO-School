package startzno.onlineschool.models;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "user_and_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {}

    public User(String username, String userPassword, Set<Role> roles) {
        this.username = username;
        this.userPassword = userPassword;
        this.roles = roles;
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
