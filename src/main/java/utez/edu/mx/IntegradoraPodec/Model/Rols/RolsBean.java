package utez.edu.mx.IntegradoraPodec.Model.Rols;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;

import java.util.Set;

@Entity
@Table(name = "rol")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RolsBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String description;


    @OneToMany(mappedBy = "rolsBean",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<EmployeesBean> employeesBeans;

    public RolsBean(Long id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }
    public RolsBean(Long id) {
        this.id = id;
    }

    public RolsBean(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
