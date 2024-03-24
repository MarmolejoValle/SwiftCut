package utez.edu.mx.IntegradoraPodec.Model.Order;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OrdenDto {
    private final Float price;
    private final LocalDate dateRequest;

    public OrdenDto(Float price, LocalDate dateRequest) {
        this.price = price;
        this.dateRequest = dateRequest;
    }
}
