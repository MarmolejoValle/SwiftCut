package utez.edu.mx.IntegradoraPodec.Model.Rols;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolsRepository extends JpaRepository<RolsBean,Long> {
        Optional<RolsBean> findById (Long id);
}
