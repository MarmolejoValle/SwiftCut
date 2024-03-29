package utez.edu.mx.IntegradoraPodec.Model.Extras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtrasRepository extends JpaRepository<ExtrasBean,Long> {

    @Query("""
select new  utez.edu.mx.IntegradoraPodec.Model.Extras.ExtraDto (pe.id , e.name , e.price )from ProductExtrasBean pe
 inner join ProductBean p on pe.productBean.id = p.id and p.id = :productId 
 inner  join ExtrasBean e on pe.extrasBean.id = e.id where pe.extrasBean.id != 2
""")
    List<ExtraDto> findByExtrasForProduct(@Param("productId") Long id);
    @Query("""
Select new  utez.edu.mx.IntegradoraPodec.Model.Extras.ExtraDto(e.id ,e.name ,e.description ,e.price) from ExtrasBean e 
""")
    List<ExtraDto> findAllFast();

}
