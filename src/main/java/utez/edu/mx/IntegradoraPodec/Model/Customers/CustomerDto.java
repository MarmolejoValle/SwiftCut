package utez.edu.mx.IntegradoraPodec.Model.Customers;

import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonDto;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolDto;

@Data

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
        email = null;
        this.token = null;
    }
    public CustomerDto(Long id , String name, String lastname, String urlPhoto) {
        this.id = id;
        this.personDto = new PersonDto(name,lastname,urlPhoto);
        this.carShopBean  = null;
        this.count = null;
        email = null;
        this.token = null;

    }

    public void setToken(String token)
    {
        this.token = token;
    }

}
