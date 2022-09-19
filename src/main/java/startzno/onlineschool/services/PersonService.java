package startzno.onlineschool.services;

import startzno.onlineschool.models.Person;

import java.util.List;
import java.util.Optional;

/**
 * Service class for {@link Person}
 *
 * @author Denys Shkolenko
 * @version 1.0
 */
public interface PersonService {

    List<Person> findAll();

    Person findById(int id);

    Optional<Person> findByUsername(String username);

    void save(Person person);

    void update(int id, Person updatedPerson);

    void delete(int id);
}
