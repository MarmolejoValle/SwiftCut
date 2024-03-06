package utez.edu.mx.IntegradoraPodec.Model.Employees;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;

import java.util.Set;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeesBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_fk")
    private PersonBean personBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_fk")
    private RolsBean rolsBean;


    @OneToMany(mappedBy = "employeesBean",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OrderBean> orderBeans;

    public EmployeesBean(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public EmployeesBean(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
