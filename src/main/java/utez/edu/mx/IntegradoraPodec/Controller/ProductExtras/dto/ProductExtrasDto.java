package utez.edu.mx.IntegradoraPodec.Controller.ProductExtras.dto;

import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;

@Data
public class ProductExtrasDto {
    private Long id ;
     private Long idExtra ;
     private Long  idProduct;
    public ProductExtrasBean toEntity (){
        return new ProductExtrasBean(idExtra , idProduct);
    }
    public ProductExtrasBean toEntityExtra (){
        return new ProductExtrasBean(idProduct );
    }



}
