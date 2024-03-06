package utez.edu.mx.IntegradoraPodec.Model.Status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;

import java.util.Set;

@Entity
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StatusBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "statusBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OrderBean> orderBeans;


    public StatusBean(String type, String description) {
        this.description = description;
        this.type = type;
    }


    public StatusBean(Long id) {
        this.id = id;
    }

    public StatusBean(Long id, String type, String description) {
        this.id = id;
        this.description = description;
        this.type = type;

    }
}
