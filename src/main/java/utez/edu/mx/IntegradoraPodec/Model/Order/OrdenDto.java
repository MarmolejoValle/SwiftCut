package utez.edu.mx.IntegradoraPodec.Model.Order;

import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomerDto;

import java.time.LocalDate;
@Data
public class OrdenDto {
    private  final Long id;
    private final Float price;
    private  final LocalDate dateRequest;
    private final CustomerDto customerDto;


    public OrdenDto(Long id , String name , String lastName , String email ) {
        this.id = id;
        CustomerDto dto = new CustomerDto( null, name,  lastName , null);
        this.customerDto = dto;
        this.dateRequest = null;
        this.price = null;
    }
    public OrdenDto(Float price, LocalDate dateRequest) {
        this.price = price;
        this.dateRequest = dateRequest;
        this.id = null;
        customerDto = null;
    }
}
