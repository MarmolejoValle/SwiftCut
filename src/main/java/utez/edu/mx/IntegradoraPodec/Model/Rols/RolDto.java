package utez.edu.mx.IntegradoraPodec.Model.Rols;

import lombok.Data;

@Data
public final class RolDto {
    private final String type;


    public RolDto(String type) {
        this.type = type;
    }
}
