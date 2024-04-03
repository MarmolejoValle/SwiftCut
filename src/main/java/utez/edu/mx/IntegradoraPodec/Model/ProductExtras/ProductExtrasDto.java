package utez.edu.mx.IntegradoraPodec.Model.ProductExtras;

import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtraDto;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductDto;

@Data
public class ProductExtrasDto {
    private final Long id;
    private final ExtraDto extraDto;
    private final ProductDto productDto ;


    public ProductExtrasDto(Long id) {
        this.id = id;
        this.extraDto = null;
        this.productDto = null;
    }
    public ProductExtrasDto(ProductDto productBean , ExtraDto extrasBean) {
        this.id = null;
        this.productDto = productBean ;
        this.extraDto = extrasBean;
    }

    public ProductExtrasDto(Long id, String name , String description , Float price) {
        this.id = id;
        this.extraDto = new ExtraDto(name, description,price);
        this.productDto = null;
    }
}
