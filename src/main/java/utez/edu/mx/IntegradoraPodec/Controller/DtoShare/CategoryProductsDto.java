package utez.edu.mx.IntegradoraPodec.Controller.DtoShare;

import lombok.Data;

@Data
public class CategoryProductsDto {
    private final Long id;
    private final String name;
    private final String urlPhoto;
    private final Long quantity;
    private final Long register ;

    public CategoryProductsDto(Long id , String name, String urlPhoto, Long quantity, Long register) {
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.quantity = quantity;
        this.register = register -1;
        this.id = id;
    }
}
