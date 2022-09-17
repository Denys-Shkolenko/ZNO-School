package startzno.onlineschool.services;

import startzno.onlineschool.models.User;

import java.util.List;

/**
 * Service class for {@link User}
 *
 * @author Denys Shkolenko
 * @version 1.0
 */
public interface UserService {

    List<User> findAll();

    User findById(int id);

    User findByUsername(String username);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
