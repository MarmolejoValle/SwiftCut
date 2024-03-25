package utez.edu.mx.IntegradoraPodec.Model.Rols;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolsRepository extends JpaRepository<RolsBean,Long> {
        Optional<RolsBean> findById (Long id);
@Query("""
select new  utez.edu.mx.IntegradoraPodec.Model.Rols.RolDto( r.type,r.id) FROM RolsBean r 
           
""")
        List<RolDto> readAllByIdAndType();
}
