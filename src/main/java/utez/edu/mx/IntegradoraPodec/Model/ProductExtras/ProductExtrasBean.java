package utez.edu.mx.IntegradoraPodec.Model.ProductExtras;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Category.CategoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Order_Item.OrderItemBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;

import java.util.Set;

@Entity
@Table(name = "product_extras")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductExtrasBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "productExtrasBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OrderItemBean> orderItemBeans;


    @OneToMany(mappedBy = "productExtrasBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<CarsItemsBean> carsItemsBeans;
    @JsonIgnore
    @OneToMany(mappedBy = "productExtrasBean",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<MovementHistoryBean> movementHistoryBeans;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_fk")
    private ProductBean productBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extras_fk")
    private ExtrasBean extrasBean;

    public ProductExtrasBean(Long idExtra, Long idProduct) {
        this.productBean  = new ProductBean();
        this.productBean.setId(idProduct);
        this.extrasBean  = new ExtrasBean();
        this.extrasBean.setId(idExtra);

    }
    public ProductExtrasBean(Long idProduct) {
        this.productBean  = new ProductBean();
        this.productBean.setId(idProduct);

    }
}
