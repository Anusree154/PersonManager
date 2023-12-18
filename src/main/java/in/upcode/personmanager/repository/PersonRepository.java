package in.upcode.personmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.upcode.personmanager.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findByName(String name);

    Optional<Person> findByNameIgnoreCase(String name);
}

