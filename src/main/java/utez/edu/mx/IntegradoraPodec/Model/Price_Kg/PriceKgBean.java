package utez.edu.mx.IntegradoraPodec.Model.Price_Kg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;

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
    private Date dateStart;
    @Column(nullable = false)
    private Date dateEnd;
    @Column(nullable = false)
    private Float priceSale;
    @Column(nullable = false)
    private Float priceBuy;

    @JsonIgnore
    @OneToMany(mappedBy = "priceKgBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OrderBean> orderBeans;

    public PriceKgBean(Long id, Date dateStart, Date dateEnd, Float priceBuy, Float priceSale) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd ;
        this.priceBuy = priceBuy;
        this.priceSale = priceSale;
    }
    public PriceKgBean( Date dateStart, Date dateEnd, Float priceBuy, Float priceSale) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd ;
        this.priceBuy = priceBuy;
        this.priceSale = priceSale;
    }
}
