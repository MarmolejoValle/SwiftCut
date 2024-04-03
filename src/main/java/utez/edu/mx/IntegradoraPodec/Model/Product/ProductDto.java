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
    public ProductDto( String name,  String urlPhoto) {
        this.id = 0L;
        this.name = name;
        this.description = null;
        this.quantity = null;
        this.urlPhoto = urlPhoto;
    }

    public ProductDto( String name,  String description , String urlPhoto) {
        this.id = 0L;
        this.name = name;
        this.description = description;
        this.quantity = null;
        this.urlPhoto = urlPhoto;
    }

    public ProductDto(String name, String description, Long quantity, String urlPhoto) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.urlPhoto = urlPhoto;
        this.id = null;
    }
}
