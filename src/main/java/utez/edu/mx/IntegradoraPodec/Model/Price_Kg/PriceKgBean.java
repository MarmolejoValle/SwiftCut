package utez.edu.mx.IntegradoraPodec.Model.Price_Kg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "price_kg")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PriceKgBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateStart;
    @Column(nullable = false)
    private LocalDateTime dateEnd;
    @Column()
    private Float priceSale;
    @Column(nullable = false)
    private Float priceBuy;

    @JsonIgnore
    @OneToMany(mappedBy = "priceKgBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OrderBean> orderBeans;

    @JsonIgnore
    @OneToMany(mappedBy = "priceKgBean", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<MovementHistoryBean> movementHistoryBeans;

    public PriceKgBean(Long id, LocalDateTime dateStart, Float priceBuy, Float priceSale) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = null ;
        this.priceBuy = priceBuy;
        this.priceSale = priceSale;
    }
    public PriceKgBean( Float priceBuy, Float priceSale) {

        this.priceBuy = priceBuy;
        this.priceSale = priceSale;
    }
    public PriceKgBean( Long id ,Float priceBuy, Float priceSale) {
        this.id = id;
        this.dateStart = null;
        this.dateEnd = null ;
        this.priceBuy = priceBuy;
        this.priceSale = priceSale;
    }
    public PriceKgBean( LocalDateTime dateStart, Float priceBuy, Float priceSale) {
        this.dateStart = dateStart;
        this.dateEnd = null ;
        this.priceBuy = priceBuy;
        this.priceSale = priceSale;
    }
}
