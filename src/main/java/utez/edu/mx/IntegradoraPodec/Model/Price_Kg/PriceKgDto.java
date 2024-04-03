package utez.edu.mx.IntegradoraPodec.Model.Price_Kg;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
public class PriceKgDto {
    private final Long id ;
    private final Float priceSale ;
    private final Float priceBuy;
    private final LocalDateTime dataStart ;
    private final LocalDateTime dataEnd ;

    public PriceKgDto(Long id, Float priceSale, Float priceBuy, LocalDateTime dataStart, LocalDateTime dataEnd) {
        this.id = id;
        this.priceSale = priceSale;
        this.priceBuy = priceBuy;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
    }

}
