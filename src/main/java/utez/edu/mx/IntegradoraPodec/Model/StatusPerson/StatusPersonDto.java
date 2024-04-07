package utez.edu.mx.IntegradoraPodec.Model.StatusPerson;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public final class StatusPersonDto {
    private final String type ;

    public StatusPersonDto (String type){
        this.type = type;
    }

}
