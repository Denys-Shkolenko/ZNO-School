package startzno.onlineschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import startzno.onlineschool.models.Role;
import startzno.onlineschool.models.Person;
import startzno.onlineschool.repositories.PersonRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Implementation of {@link UserDetailsService}
 *
 * @author Denys Shkolenko
 * @version 1.0
 */
@Service
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : person.get().getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(person.get().getUsername(), person.get().getUserPassword(), grantedAuthorities);
    }
}
