package utez.edu.mx.IntegradoraPodec.Model.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomerDto;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtraDto;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductDto;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto;
import utez.edu.mx.IntegradoraPodec.Model.Status.StatusDto;

import java.time.LocalDate;
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrdenDto {
    private  final Long id;
    private final Float price;
    private  final LocalDate dateRequest;
    private final CustomerDto customerDto;
    private final Long count ;
    private final Double total ;
    private final ProductExtrasDto productExtrasDto;
    private final StatusDto statusDto;
    private final String longitude;
    private final String latitude;
    public OrdenDto(Long id , String name , String lastName , String email , Long count , Object total  , String latitude ,String longitude  , Float price) {
        this.id = id;
        CustomerDto dto = new CustomerDto( null, name,  lastName , null);
        this.customerDto = dto;
        this.dateRequest = null;
        this.price = price;
        this.total = (Double) total;
        this.count = count ;
        this.productExtrasDto = null;
        this.statusDto  = null;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public OrdenDto(Long id , String name , String lastName , String email , Long count , Object total ) {
        this.id = id;
        CustomerDto dto = new CustomerDto( null, name,  lastName , null);
        this.customerDto = dto;
        this.dateRequest = null;
        this.price = null;
        this.total = (Double) total;
        this.count = count ;
        this.productExtrasDto = null;
        this.statusDto  = null;
        longitude = null;
        latitude = null;
    }
    public OrdenDto(Long id , String name , String lastName , String email , Long count , Object total , LocalDate dateRequest , String type , String descriptionStatus) {
        this.id = id;
        CustomerDto dto = new CustomerDto( null, name,  lastName , null);
        this.customerDto = dto;
        this.dateRequest = dateRequest;
        this.price = null;
        this.total = (Double) total;
        this.count = count ;
        this.productExtrasDto = null;
        this.statusDto  = new StatusDto(type,descriptionStatus);
        longitude = null;
        latitude = null;
    }


    public OrdenDto(Long id , String name , String lastName , String email ) {
        this.id = id;
        CustomerDto dto = new CustomerDto( null, name,  lastName , null);
        this.customerDto = dto;
        this.dateRequest = null;
        this.price = null;
        this.total = null;
        this.count = 0L ;
        this.productExtrasDto = null;
        this.statusDto  = null;

        longitude = null;
        latitude = null;
    }
    public OrdenDto(Float price, LocalDate dateRequest) {
        this.price = price;
        this.dateRequest = dateRequest;
        this.id = null;
        customerDto = null;
        this.total = null;
        this.count = 0L ;
        this.productExtrasDto = null;
        this.statusDto  = null;


        longitude = null;
        latitude = null;
    }

    public OrdenDto(String nameProduct  , String urlPhoto , String descriptionProduct , String nameExtra , String descriptionExtra , Float quantity , Float priceExtra) {
        this.price = null;
        this.dateRequest = null;
        this.id = null;
        customerDto = null;
        this.statusDto  = null;

        this.total = Double.valueOf(quantity);
        this.count = 0L ;
        ExtraDto extraDto = new ExtraDto(nameExtra,descriptionExtra,priceExtra);
        ProductDto productDto = new ProductDto(nameProduct,descriptionProduct, urlPhoto );
        this.productExtrasDto = new ProductExtrasDto(productDto,extraDto);

        longitude = null;
        latitude = null;
    }
}
