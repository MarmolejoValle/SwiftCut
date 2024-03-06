package utez.edu.mx.IntegradoraPodec.Controller.Customer.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;

@Data
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String email;
    private String password;

    public CustomersBean toEntity(){
        return new CustomersBean(email, password);
    }

    public CustomersBean toEntityId(){
        return new CustomersBean(id, email, password) ;
    }
}
