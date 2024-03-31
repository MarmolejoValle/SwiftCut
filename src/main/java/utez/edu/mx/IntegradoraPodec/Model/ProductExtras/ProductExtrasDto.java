package utez.edu.mx.IntegradoraPodec.Model.ProductExtras;

import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;

@Data
public class ProductExtrasDto {
    private final Long id;
    private final ExtrasBean extrasBean;
    private final ProductBean productBean ;


    public ProductExtrasDto(Long id) {
        this.id = id;
        this.extrasBean = null;
        this.productBean = null;
    }
    public ProductExtrasDto(ProductBean productBean , ExtrasBean extrasBean) {
        this.id = null;
        this.productBean = productBean ;
        this.extrasBean = extrasBean;
    }

    public ProductExtrasDto(Long id, String name , String description , Float price) {
        this.id = id;
        this.extrasBean = new ExtrasBean();
        this.extrasBean.setName(name);
        this.extrasBean.setDescription(description);
        this.extrasBean.setPrice(price);
        this.productBean = null;
    }
}
