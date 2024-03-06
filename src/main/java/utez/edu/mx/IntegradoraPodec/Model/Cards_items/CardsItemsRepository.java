package utez.edu.mx.IntegradoraPodec.Model.Cards_items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsItemsRepository extends JpaRepository<CarsItemsBean,Long> {
    Optional <CarsItemsBean> findById (Long id);
    //Optional <CardsItemsBean> deleteById (Long id);
}
