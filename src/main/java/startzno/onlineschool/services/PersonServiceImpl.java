package startzno.onlineschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import startzno.onlineschool.models.Person;
import startzno.onlineschool.models.Role;
import startzno.onlineschool.repositories.RoleRepository;
import startzno.onlineschool.repositories.PersonRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Implementation of {@link PersonService} interface.
 *
 * @author Denys Shkolenko
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository,
                             RoleRepository roleRepository,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public Person findById(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public Optional<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    @Transactional
    public void save(Person person) {
        person.setUserPassword(bCryptPasswordEncoder.encode(person.getUserPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getReferenceById(1));
        person.setRoles(roles);
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
