package utez.edu.mx.IntegradoraPodec.Model.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Category.CategoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Order_Item.OrderItemBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;

import java.util.Set;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String quantity;




    @OneToMany(mappedBy = "productBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ProductExtrasBean> productExtrasBeans;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk")
    private CategoryBean categoryBean;




    public ProductBean(String name, String description, String  quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductBean(Long id, String name, String description, String quantity) {
    }
}
