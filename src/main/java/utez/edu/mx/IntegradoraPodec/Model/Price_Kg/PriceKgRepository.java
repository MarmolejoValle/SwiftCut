package utez.edu.mx.IntegradoraPodec.Model.Price_Kg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceKgRepository  extends JpaRepository<PriceKgBean,Long> {

    @Query("""
select new  utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgDto(pk.id , pk.priceSale , pk.priceBuy , pk.dateStart , pk.dateEnd)
from  PriceKgBean pk where  pk.dateEnd is null  
""")
    Optional<PriceKgDto> findNullPriceKg();
}
