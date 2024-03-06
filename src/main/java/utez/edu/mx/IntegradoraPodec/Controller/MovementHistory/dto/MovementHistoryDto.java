package utez.edu.mx.IntegradoraPodec.Controller.MovementHistory.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryBean;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class MovementHistoryDto {
    private Long id;
    private LocalDateTime date;
    private Float quantity;

    public MovementHistoryBean toEntityId(){
        return new MovementHistoryBean(id,date, quantity) ;
    }
    public MovementHistoryBean toEntity(){
        return new MovementHistoryBean(date, quantity);
    }
}
