package utez.edu.mx.IntegradoraPodec.Model.Extras;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class ExtraDto {
    private final Long id;
    private final String name;
    private final String description;
    private final Float price;

    public ExtraDto(String name , Float price) {
        this.id = 0L;
        this.name = name;
        this.description = null;
        this.price = price;
    }
    public ExtraDto(String name, String description , Float price) {
        this.id = 0L;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public ExtraDto(Long id, String name, String description, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public ExtraDto(Long id, String name,  Float price , String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
