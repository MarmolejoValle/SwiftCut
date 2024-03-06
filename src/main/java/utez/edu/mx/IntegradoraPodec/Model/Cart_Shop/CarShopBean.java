package utez.edu.mx.IntegradoraPodec.Model.Cart_Shop;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;

import java.util.Set;

@Entity
@Table(name = "carShop")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CarShopBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_fk")
    private CustomersBean customersBean;

    @OneToMany(mappedBy = "carShopBean",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<CarsItemsBean> carsItemsBeans;


    public CarShopBean(Long id) {
        this.id = id;
    }
}
