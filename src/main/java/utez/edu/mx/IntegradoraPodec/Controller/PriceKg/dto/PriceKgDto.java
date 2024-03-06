package utez.edu.mx.IntegradoraPodec.Controller.PriceKg.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgBean;
import java.util.Date;
@Data
@Getter
@Setter
public class PriceKgDto {

    private Long id;
    private Date date_start;
    private Date date_end;
    private Float price_sale;
    private Float price_buy;

    public PriceKgBean toEntityId(){
        return new PriceKgBean(id,date_start,date_end,price_buy,price_sale) ;
    }
    public PriceKgBean toEntity(){
        return new PriceKgBean(date_start,date_end,price_buy,price_sale);
    }
}
