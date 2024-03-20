package utez.edu.mx.IntegradoraPodec.Model.Movement_History;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Category.CategoryBean;
import utez.edu.mx.IntegradoraPodec.Model.MovementType.MovementTypeBean;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;

import java.time.LocalDateTime;

@Entity
@Table(name = "movement_history")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MovementHistoryBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private Float quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_mov_fk")
    private MovementTypeBean movementTypeBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_extras_fk")
    private ProductExtrasBean productExtrasBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_kg_fk")
    private PriceKgBean priceKgBean;

    public MovementHistoryBean( LocalDateTime date, Float quantity) {
        this.date = date;
        this.quantity = quantity;
    }
    public MovementHistoryBean( Long id ,LocalDateTime date, Float quantity) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
    }


}
