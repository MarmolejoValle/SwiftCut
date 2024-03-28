package utez.edu.mx.IntegradoraPodec.Model.Product;

import lombok.Data;

@Data
public class ProductDto {
    private final Long id;
    private final String name;
    private final String description;
    private final Long quantity;
    private final String urlPhoto;

    public ProductDto(Long id, String name, String description, Long quantity, String urlPhoto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.urlPhoto = urlPhoto;
    }
}
