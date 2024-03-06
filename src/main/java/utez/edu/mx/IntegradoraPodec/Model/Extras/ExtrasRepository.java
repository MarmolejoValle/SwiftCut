package utez.edu.mx.IntegradoraPodec.Model.Extras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtrasRepository extends JpaRepository<ExtrasBean,Long> {
}
