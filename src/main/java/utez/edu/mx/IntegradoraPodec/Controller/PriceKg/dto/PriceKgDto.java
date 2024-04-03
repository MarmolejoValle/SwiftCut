package utez.edu.mx.IntegradoraPodec.Controller.PriceKg.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgBean;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Getter
@Setter
public class PriceKgDto {

    private Long id;
    private Float priceSale;
    private Float priceBuy;

    public PriceKgBean toEntityId(){
        return new PriceKgBean(id,priceBuy,priceSale) ;
    }
    public PriceKgBean toEntity(){
        return new PriceKgBean(priceBuy,priceSale);
    }
}
