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
    private int quantity;

    public CarsItemsBean toEntity(){
        return new CarsItemsBean(quantity);
    }

    public CarsItemsBean toEntityId(){
        return new CarsItemsBean(id, quantity) ;
    }

}
