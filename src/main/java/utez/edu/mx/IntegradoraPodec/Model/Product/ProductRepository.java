package utez.edu.mx.IntegradoraPodec.Model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utez.edu.mx.IntegradoraPodec.Controller.DtoShare.CategoryProductsDto;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtraDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean,Long> {
    @Query("""
        Select new utez.edu.mx.IntegradoraPodec.Model.Product.ProductDto(p.id , p.name,p.description
        , p.quantity,p.urlPhoto) from ProductBean  p where p.id = :productId
""")
    Optional<ProductBean> findByIdFast (@Param("productId")Long id);

    @Query("""
        Select new utez.edu.mx.IntegradoraPodec.Model.Product.ProductDto(p.id , p.name,p.description
        , p.quantity,p.urlPhoto) from ProductBean p 
""")
    List<ProductDto> findTop5Products ();
    @Query("""
select new utez.edu.mx.IntegradoraPodec.Controller.DtoShare.CategoryProductsDto(p.id,p.name, p.urlPhoto , p.quantity , count (pe.productBean.id)  )  from CategoryBean c
    inner join ProductBean p on c.id= p.categoryBean.id inner  JOIN ProductExtrasBean pe on p.id = pe.productBean.id where c.id =:idCategory group by pe.productBean.id    
""")
    List<CategoryProductsDto> findByProductForCategory(@Param("idCategory") Long idCategory);



    @Query("""
select new  utez.edu.mx.IntegradoraPodec.Model.Product.ProductDto (p.name , p.description , p.quantity , p.urlPhoto )from ProductExtrasBean pe
 inner join ProductBean p on pe.productBean.id = p.id 
 inner  join ExtrasBean e on pe.extrasBean.id = e.id and e.id = :extrasId 
""")
    List<ProductDto> findByProductforExtras(@Param("extrasId") Long id);


    @Query("""
        Select new utez.edu.mx.IntegradoraPodec.Model.Product.ProductDto(p.id , p.name,p.description
        , p.quantity,p.urlPhoto) from ProductBean p 
        inner join CategoryBean c on c.id = :idCategory
""")
    List<ProductDto> findProductsForCategory (@Param("idCategory") Long idCategory);
}
