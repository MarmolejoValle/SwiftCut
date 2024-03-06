package utez.edu.mx.IntegradoraPodec.Controller.Order.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Order;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;

import java.time.LocalDate;
import java.util.Date;

@Data
@Getter
@Setter
public class OrderDto {
    private Long id;
    private LocalDate dateRequest;
    private LocalDate datesending;
    private String description;
    private LocalDate dateDelivered;
    private String direction;

    public OrderBean toEntity(){
        return new OrderBean(dateRequest, datesending, description, dateDelivered,direction );
    }

    public OrderBean toEntityId(){
        return new OrderBean(id, dateRequest, datesending, description, dateDelivered,direction );
    }
}

