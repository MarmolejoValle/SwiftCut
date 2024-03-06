package utez.edu.mx.IntegradoraPodec.Controller.MovementType.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.MovementType.MovementTypeBean;

@Data
@Getter
@Setter
public class MovementTypeDto {
    private Long id;
    private String type;

    public MovementTypeBean toEntityId(){
        return new MovementTypeBean(id,type) ;
    }
    public MovementTypeBean toEntity(){
        return new MovementTypeBean(type);
    }
}
