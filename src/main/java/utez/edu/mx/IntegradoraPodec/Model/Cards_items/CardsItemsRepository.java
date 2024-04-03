package utez.edu.mx.IntegradoraPodec.Model.Cards_items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utez.edu.mx.IntegradoraPodec.Controller.Cards_items.dto.Cards_itemsDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardsItemsRepository extends JpaRepository<CarsItemsBean,Long> {
    Optional <CarsItemsBean> findById (Long id);



    //Optional <CardsItemsBean> deleteById (Long id);
    @Query("""

SELECT NEW
    utez.edu.mx.IntegradoraPodec.Model.Cards_items.CardsItemsDto (p.id , ct.quantity , p.name , e.name , p.urlPhoto , e.price)
from CarsItemsBean ct
         inner join CarShopBean  cs on cs.id = :idCarShop
         inner join ProductExtrasBean px on px.id = ct.productExtrasBean.id
         inner join ExtrasBean  e on px.extrasBean.id= e.id
         inner join ProductBean  p on px.productBean.id= p.id

    
""")
    List<CardsItemsDto> getAllForCarShop (@Param("idCarShop") Long idCarShop);
}
