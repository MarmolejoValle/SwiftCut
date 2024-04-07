package utez.edu.mx.IntegradoraPodec.Model.ProductExtras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductExtrasRepository extends JpaRepository<ProductExtrasBean,Long> {

    @Query("""
SELECT NEW utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto(px.id) from ProductExtrasBean  px 
 where px.extrasBean.id = :idExtra and px.productBean.id = :idProduct
""")
    Optional<ProductExtrasDto> findByProductAndExtra(@Param("idProduct") Long idProduct , @Param("idExtra") Long idExtra  );

    @Query("""
SELECT NEW utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto(px.id , e.name,e.description,e.price) from ProductExtrasBean  px 
inner join ExtrasBean  e on e.id = px.extrasBean.id
 where   px.productBean.id = :idProduct
""")
    List<ProductExtrasDto> findByExtras(@Param("idProduct") Long idProduct  );

    @Query("""
select new  utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto(px.id) from ProductExtrasBean px
inner join ExtrasBean e on px.extrasBean.id = e.id and e.name ='Sin Extras'
where px.productBean.id =  :idProduct
""")
    Optional<ProductExtrasDto> findProductExtrasForProduct (@Param("idProduct") Long idProduct);



}
