package utez.edu.mx.IntegradoraPodec.Model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonBean,Long> {
    Optional<PersonBean> findById (Long id);
}
