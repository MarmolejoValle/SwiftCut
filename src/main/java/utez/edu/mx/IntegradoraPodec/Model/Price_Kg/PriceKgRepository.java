package utez.edu.mx.IntegradoraPodec.Model.Price_Kg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceKgRepository  extends JpaRepository<PriceKgBean,Long> {
}
