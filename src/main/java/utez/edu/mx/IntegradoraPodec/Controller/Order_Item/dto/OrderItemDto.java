package utez.edu.mx.IntegradoraPodec.Controller.Order_Item.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Order_Item.OrderItemBean;

@Data
@Getter
@Setter
public class OrderItemDto {
    private Long id;
    private int quantity;
    private double price;

    public OrderItemBean toEntity(){
        return new OrderItemBean(quantity, price);
    }

    public OrderItemBean toEntityId(){
        return new OrderItemBean(id, quantity, price) ;
    }
}
