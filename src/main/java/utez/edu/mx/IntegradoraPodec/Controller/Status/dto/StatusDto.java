package utez.edu.mx.IntegradoraPodec.Controller.Status.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Status.StatusBean;
@Data
@Getter
@Setter
public class StatusDto {
    private Long id;
    private String type;
    private String description;

    public StatusBean toEntityId(){
        return new StatusBean(id,type, description) ;
    }
    public StatusBean toEntity(){
        return new StatusBean(type, description);
    }
}
