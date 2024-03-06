package utez.edu.mx.IntegradoraPodec.Model.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository  extends JpaRepository<StatusBean,Long> {
}
