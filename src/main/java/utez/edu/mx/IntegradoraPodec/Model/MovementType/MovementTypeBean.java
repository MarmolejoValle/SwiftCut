package utez.edu.mx.IntegradoraPodec.Model.MovementType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Order_Item.OrderItemBean;

import java.util.Set;

@Entity
@Table(name = "movement_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovementTypeBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;


    @OneToMany(mappedBy = "movementTypeBean",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<MovementHistoryBean> movementHistoryBeans;



    public MovementTypeBean( String type) {
        this.type = type;
    }

    public MovementTypeBean(Long id, String type) {
        this.id = id;
        this.type = type;
    }
}
