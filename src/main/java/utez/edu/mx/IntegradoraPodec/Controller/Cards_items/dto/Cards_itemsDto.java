package utez.edu.mx.IntegradoraPodec.Controller.Cards_items.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;

@Data
@Getter
@Setter
public class Cards_itemsDto {
    private Long id;
    private Long idProductExtra;
    private int quantity;
    private Long carId;


    public CarsItemsBean toEntityAdd(){
        return new CarsItemsBean(carId,idProductExtra,quantity);
    }

    public CarsItemsBean toEntity(){
        return new CarsItemsBean(quantity);
    }

    public CarsItemsBean toEntityId(){
        return new CarsItemsBean(id, quantity) ;
    }

}
