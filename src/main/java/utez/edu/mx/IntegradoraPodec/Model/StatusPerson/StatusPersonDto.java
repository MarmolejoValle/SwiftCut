package utez.edu.mx.IntegradoraPodec.Model.StatusPerson;

import lombok.Data;

@Data

public final class StatusPersonDto {
    private final String type ;

    public StatusPersonDto (String type){
        this.type = type;
    }

}
