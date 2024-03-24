package utez.edu.mx.IntegradoraPodec.Model.StatusPerson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;

import java.util.Set;

@Entity
@Table(name = "status_person")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StatusPersonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "statusPersonBean",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<PersonBean> PersonBean;


    public StatusPersonBean(String type, String description) {
        this.description = description;
        this.type = type;
    }


    public StatusPersonBean(Long id) {
        this.id = id;
    }

    public StatusPersonBean(Long id, String type, String description) {
        this.id = id;
        this.description = description;
        this.type = type;

    }
}
