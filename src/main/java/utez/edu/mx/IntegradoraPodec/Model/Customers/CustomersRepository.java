package utez.edu.mx.IntegradoraPodec.Model.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto;

import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersBean,Long> {

    @Query("""
                   SELECT new  utez.edu.mx.IntegradoraPodec.Model.Customers.CustomerDto (c.id , p.name,p.lastName,p.urlPhoto)
                  FROM PersonBean p
                   inner join CustomersBean c on p.id=c.personBean.id and c.email =:email                 
                   """)
    Optional<CustomerDto> findByInfo(@Param("email")String username);
    Optional<CustomersBean> findByEmail(String username);

    @Query("""
                   SELECT new  utez.edu.mx.IntegradoraPodec.Model.Customers.CustomerDto (c.id , p.name,p.lastName,p.urlPhoto , car.id)
                  FROM PersonBean p
                   inner join CustomersBean c on p.id=c.personBean.id and c.email =:email      
                   inner join CarShopBean car on car.id = c.carShopBean.id
                   """)
    Optional<CustomerDto> findByEmailLocal(@Param("email")String username);

}
