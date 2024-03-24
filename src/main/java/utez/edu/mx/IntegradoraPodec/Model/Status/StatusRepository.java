package utez.edu.mx.IntegradoraPodec.Model.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository  extends JpaRepository<StatusBean,Long> {


}
