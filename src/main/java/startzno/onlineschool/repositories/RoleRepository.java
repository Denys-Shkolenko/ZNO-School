package startzno.onlineschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import startzno.onlineschool.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
