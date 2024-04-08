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
    private Float  quantity;


    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "car_shop_fk")
    private CarShopBean carShopBean;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_extras_fk")
    private ProductExtrasBean productExtrasBean;

    public CarsItemsBean(Float quantity) {
        this.quantity = quantity;
    }

    public CarsItemsBean(Long id, Float quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    public CarsItemsBean(Long carId , Long idProductExtra, Float quantity) {
        CarShopBean carShopBean = new CarShopBean();
        carShopBean.setId(carId);
        this.carShopBean = carShopBean;

        ProductExtrasBean productExtrasBean = new ProductExtrasBean();
        productExtrasBean.setId(idProductExtra);

        this.productExtrasBean = productExtrasBean;

        this.quantity = quantity;
    }
}

