package utez.edu.mx.IntegradoraPodec.Model.Cards_items;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;

@Entity
@Table(name = "carsItems")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CarsItemsBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_shop_fk")
    private CarShopBean carShopBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_extras_fk")
    private ProductExtrasBean productExtrasBean;

    public CarsItemsBean(int quantity) {
        this.quantity = quantity;
    }

    public CarsItemsBean(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}

