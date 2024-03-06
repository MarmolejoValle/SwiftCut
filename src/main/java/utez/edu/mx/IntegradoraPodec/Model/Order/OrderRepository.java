package utez.edu.mx.IntegradoraPodec.Model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderBean,Long> {
    Optional<OrderBean> findById (Long id);
}
