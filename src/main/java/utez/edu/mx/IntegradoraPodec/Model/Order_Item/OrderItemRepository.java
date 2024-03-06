package utez.edu.mx.IntegradoraPodec.Model.Order_Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemBean,Long> {
}
