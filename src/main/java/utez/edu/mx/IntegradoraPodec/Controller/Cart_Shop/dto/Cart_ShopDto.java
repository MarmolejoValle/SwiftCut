package utez.edu.mx.IntegradoraPodec.Controller.Cart_Shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;

@Data
@Getter
@Setter
public class Cart_ShopDto {
    private Long id;

    public CarShopBean toEntityId(){
        return new CarShopBean(id) ;
    }

}
