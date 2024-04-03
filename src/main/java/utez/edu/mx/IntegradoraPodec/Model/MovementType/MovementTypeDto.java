package utez.edu.mx.IntegradoraPodec.Model.MovementType;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MovementTypeDto {
    private final Long id;
    private final String type;

    public MovementTypeDto(Long id, String type) {
        this.id = id;
        this.type = type;
    }
}
