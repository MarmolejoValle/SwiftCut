package utez.edu.mx.IntegradoraPodec.Model.Status;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class StatusDto {
    private Long id;
    private String type;
    private String description;

    public StatusDto(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
