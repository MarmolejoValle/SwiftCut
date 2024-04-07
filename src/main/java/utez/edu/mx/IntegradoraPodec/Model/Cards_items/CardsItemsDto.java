package utez.edu.mx.IntegradoraPodec.Model.Cards_items;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtraDto;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductDto;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class CardsItemsDto {
    private final Long id;
    private final Float quantity;
    private final ProductExtrasDto productExtrasDto;

    public CardsItemsDto(Long id){

        this.productExtrasDto = null;
        this.id = null;
        quantity = null;
    }
    public CardsItemsDto(Long id , Float quantity , String nameProduct , String nameExtra , String urlPhoto , Float price){
        this.id = id;
        this.quantity = quantity;
        ProductDto productDto = new ProductDto(nameProduct,urlPhoto);

        ExtraDto extraDto = new ExtraDto(nameExtra , price);

        ProductExtrasDto productExtrasDto = new ProductExtrasDto(productDto , extraDto);

        this.productExtrasDto = productExtrasDto;

    }
    /*Nombre de producot , nombre extra , cantidad  , quanttity */
}
