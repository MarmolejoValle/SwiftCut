package utez.edu.mx.IntegradoraPodec.Model.Order_Item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;

@Entity
@Table(name = "orderItem")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderItemBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_fk")
    private OrderBean orderBean;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_extras_fk")
    private ProductExtrasBean productExtrasBean;





    public OrderItemBean(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemBean(Long id, int quantity) {
        this.id = id ;
        this.quantity = quantity;
    }
}
