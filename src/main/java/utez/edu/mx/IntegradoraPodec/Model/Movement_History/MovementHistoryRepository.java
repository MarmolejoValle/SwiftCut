package utez.edu.mx.IntegradoraPodec.Model.Movement_History;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementHistoryRepository  extends JpaRepository<MovementHistoryBean,Long> {

    @Query("""
Select new utez.edu.mx.IntegradoraPodec.Model.Movement_History.GraficsDto(mh.date , mh.quantity ,my.type, p.name)
from MovementHistoryBean mh
inner join MovementTypeBean my on my.id = mh.movementTypeBean.id
inner join ProductExtrasBean  px  on px.id = mh.productExtrasBean.id 
inner join ProductBean  p on p.id = px.productBean.id
inner join PriceKgBean  pk on pk.id = mh.priceKgBean.id and  pk.id = :idPrice
 order by mh.date desc 
""")
    List<GraficsDto> getAll(@Param("idPrice") Long idPrice) ;

    @Query("""
Select new utez.edu.mx.IntegradoraPodec.Model.Movement_History.GraficsDto(c.name , COUNT(c.name) ,c.name)
from MovementHistoryBean mh
         inner join ProductExtrasBean  px  on px.id = mh.productExtrasBean.id
         inner join MovementTypeBean my on my.id = mh.movementTypeBean.id and my.id = 3
         inner join ProductBean  p on p.id = px.productBean.id
        inner join CategoryBean c on c.id = p.categoryBean.id
        inner join PriceKgBean  pk on pk.id = mh.priceKgBean.id and  pk.id = :idPrice
        group by c.name
""")
    List<GraficsDto> categoryData(@Param("idPrice") Long idPrice);

    @Query("""
Select new utez.edu.mx.IntegradoraPodec.Model.Movement_History.GraficsDto(
 mt.type , sum(mh.quantity) ) from MovementHistoryBean mh
inner join PriceKgBean pk on mh.priceKgBean.id = pk.id
inner join MovementTypeBean mt on mh.movementTypeBean.id = mt.id
group by mt.type
""")
    List<GraficsDto> quantityCategory(@Param("idPrice") Long idPrice);


}
