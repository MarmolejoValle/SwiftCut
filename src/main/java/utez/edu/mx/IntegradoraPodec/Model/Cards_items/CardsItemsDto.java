package utez.edu.mx.IntegradoraPodec.Model.Cards_items;

import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto;

@Data
public class CardsItemsDto {
    private final Long id;
    private final int quantity;
    private final ProductExtrasDto productExtrasDto;

    public CardsItemsDto(Long id){

        this.productExtrasDto = null;
        this.id = null;
        quantity = 0;
    }
    public CardsItemsDto(Long id , int quantity , String nameProduct , String nameExtra , String urlPhoto){
        this.id = id;
        this.quantity = quantity;
        ProductBean productBean = new ProductBean();
        productBean.setName(nameProduct);
        productBean.setUrlPhoto(urlPhoto);
        ExtrasBean extrasBean = new ExtrasBean();
        extrasBean.setName(nameExtra);
        ProductExtrasDto productExtrasDto = new ProductExtrasDto(productBean , extrasBean);

        this.productExtrasDto = productExtrasDto;

    }
    /*Nombre de producot , nombre extra , cantidad  , quanttity */
}
