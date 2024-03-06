package utez.edu.mx.IntegradoraPodec.Model.Cart_Shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartShopRepository extends JpaRepository<CarShopBean,Long> {
}
