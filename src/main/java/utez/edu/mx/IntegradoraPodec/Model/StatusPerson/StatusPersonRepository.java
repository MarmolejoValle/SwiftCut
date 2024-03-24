package utez.edu.mx.IntegradoraPodec.Model.StatusPerson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPersonRepository extends JpaRepository<StatusPersonBean,Long> {
}
