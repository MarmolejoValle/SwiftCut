package utez.edu.mx.IntegradoraPodec.Model.Extras;

import lombok.Data;

@Data
public class ExtraDto {
    private final Long id;
    private final String name;
    private final String description;
    private final Float price;



    public ExtraDto(Long id, String name, String description, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public ExtraDto(Long id, String name,  Float price) {
        this.id = id;
        this.name = name;
        this.description = null;
        this.price = price;
    }
}
