package utez.edu.mx.IntegradoraPodec.Controller.Extras.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;

@Data
@Getter
@Setter
public class ExtrasDto {
    private Long id;
    private String name;
    private String description;
    private Float price;
    public ExtrasBean toEntityId(){
        return new ExtrasBean(id,name, description, price) ;
    }
    public ExtrasBean toEntity(){
        return new ExtrasBean(name, description, price);
    }
}
