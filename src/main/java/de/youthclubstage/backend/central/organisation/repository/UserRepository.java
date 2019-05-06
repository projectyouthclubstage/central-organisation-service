package de.youthclubstage.backend.central.organisation.repository;

import de.youthclubstage.backend.central.organisation.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByFirstName(String firstName);

    Optional<User> findByLastName(String lastName);

}
