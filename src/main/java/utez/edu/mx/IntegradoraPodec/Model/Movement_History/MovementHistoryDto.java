package utez.edu.mx.IntegradoraPodec.Model.Movement_History;

import jakarta.persistence.Column;
import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto;

import java.time.LocalDateTime;

@Data
public class MovementHistoryDto {
    private final Long id;
    private final LocalDateTime date;
    private final Float quantity;
    private final MovementHistoryDto historyDto ;
    private final ProductExtrasDto extrasDto ;








}
