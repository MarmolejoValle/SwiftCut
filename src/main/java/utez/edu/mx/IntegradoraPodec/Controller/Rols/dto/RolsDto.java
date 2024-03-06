package utez.edu.mx.IntegradoraPodec.Controller.Rols.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;

@Data
@Getter
@Setter
public class RolsDto {
    private Long id;
    private String type;
    private String description;

    public RolsBean toEntity(){
        return new RolsBean(type, description);
    }

    public RolsBean toEntityId(){
        return new RolsBean(id, type, description) ;
    }
}
