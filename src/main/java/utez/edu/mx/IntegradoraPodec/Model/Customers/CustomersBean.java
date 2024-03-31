package utez.edu.mx.IntegradoraPodec.Model.Customers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;

import java.util.Set;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomersBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person")
    private PersonBean personBean;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private Boolean status;
    @Column(columnDefinition = "BOOL DEFAULT false")
    private Boolean blocked;
    private String token;

    @OneToOne(mappedBy = "customersBean", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private CarShopBean carShopBean;


    @OneToMany(mappedBy = "customersBean",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OrderBean> orderBeans;

    public CustomersBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public CustomersBean(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
