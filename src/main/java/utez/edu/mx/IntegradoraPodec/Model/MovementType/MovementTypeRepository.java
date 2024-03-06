package utez.edu.mx.IntegradoraPodec.Model.MovementType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementTypeRepository  extends JpaRepository<MovementTypeBean,Long> {
}
