package utez.edu.mx.IntegradoraPodec.Model.Extras;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;

import java.util.Set;

@Entity
@Table(name = "extras")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExtrasBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Float price;
    @JsonIgnore
    @OneToMany(mappedBy = "extrasBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ProductExtrasBean> productExtrasBeans;


    public ExtrasBean(String name, String description, Float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ExtrasBean(Long id, String name, String description, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
