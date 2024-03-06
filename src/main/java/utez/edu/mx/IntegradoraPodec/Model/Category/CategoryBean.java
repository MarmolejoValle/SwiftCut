package utez.edu.mx.IntegradoraPodec.Model.Category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;

import java.util.Set;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "categoryBean",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ProductBean> productBeans;


    public CategoryBean(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryBean(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
