package utez.edu.mx.IntegradoraPodec.Model.Movement_History;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GraficsDto {
    private final LocalDateTime dateTime;
    private final Float quantity ;
    private final String type ;
    private final String product ;

    private final String  name ;
    private final Long count ;

    public GraficsDto(LocalDateTime dateTime, Float quantity, String type ,String product) {
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.type = type;
        this.product = product;
        this.name = null;
        this.count = null;

    }
    public GraficsDto(String name ,Long count , String a) {
        this.dateTime = null;
        this.quantity = null;
        this.type = null;
        this.product = null;
        this.name = name;
        this.count = count;

    }
    public GraficsDto(String name ,Double quantity) {
        this.dateTime = null;
        this.quantity = quantity.floatValue();
        this.type = null;
        this.product = null;
        this.name = name;
        this.count = null;

    }

}
