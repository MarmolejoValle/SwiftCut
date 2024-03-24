package utez.edu.mx.IntegradoraPodec.Model.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Status.StatusBean;
import utez.edu.mx.IntegradoraPodec.Model.StatusPerson.StatusPersonBean;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String sex ;
    @Column(nullable = false, length = 10)
    private String phone;
    @Column()
    private String urlPhoto;

    @JsonIgnore
    @OneToOne(mappedBy = "personBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CustomersBean customersBean;
    @JsonIgnore
    @OneToOne(mappedBy = "personBean", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private EmployeesBean employeesBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_person_fk")
    private StatusPersonBean statusPersonBean;

    public PersonBean(Long id, String name, String lastName, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public PersonBean(String name, String lastName, String phone ) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }
}
