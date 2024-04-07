package utez.edu.mx.IntegradoraPodec.Model.Customers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonDto;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolDto;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class CustomerDto {

    private final Long id;
    private final String email;
    private final Long count;
    private String token ;
    private PersonDto personDto;
    private CarShopBean carShopBean;
    public CustomerDto(Long id , String name, String lastname, String urlPhoto , Long idCar) {
        this.id = id;
        this.personDto = new PersonDto(name,lastname,urlPhoto);
        this.carShopBean  = new CarShopBean();
        this.carShopBean.setId(idCar);
        this.count = null;
        this.email = null;
        this.token = null;
    }
    public CustomerDto(Long id , String name, String lastname, String urlPhoto  ) {
        this.id = id;
        this.personDto = new PersonDto(name,lastname,urlPhoto);
        this.carShopBean  = null;
        this.count = null;
        this.email = null;
        this.token = null;

    }
    public CustomerDto(Long id , String name , String lastName , String urlPhoto , String email , String phone , String sex ){

        this.id = id;
        this.personDto = new PersonDto(name,lastName,"",urlPhoto , phone , sex);
        this.carShopBean  = null;
        this.count = null;
        this.email = email;
        this.token = null;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

}
