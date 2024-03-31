package utez.edu.mx.IntegradoraPodec.Model.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto;
import utez.edu.mx.IntegradoraPodec.Model.StatusPerson.StatusPersonBean;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesBean,Long> {
    Optional<EmployeesBean> findById (Long id);
    Optional<EmployeesBean> findByEmail(String username);
    @Query("""
                   SELECT new  utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto (e.id , p.name,p.lastName,r.type,p.urlPhoto)
                  FROM PersonBean p
                   inner join EmployeesBean e on p.id=e.personBean.id and e.email =:email
                   inner join RolsBean r on e.rolsBean.id = r.id                     
                   """)
    Optional<EmployeesDto> findByInfo(@Param("email")String username);

    Optional<EmployeesBean> findByEmailAndAndPassword(String email , String password);
    @Query("""
                   SELECT new utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto(count(o.id) ) from EmployeesBean e inner join OrderBean o on e.id = o.employeesBean.id INNER JOIN 
                   StatusBean s on o.statusBean.id = 1 where e.id= :id
                   """)
    Optional<EmployeesDto> getCountOrdens(@Param("id") Long id);

    @Query("""
                   SELECT new utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto(o.priceKgBean.priceSale , o.dateRequest) from EmployeesBean e inner join OrderBean o on e.id = o.employeesBean.id 
                   INNER JOIN StatusBean s on o.statusBean.id = 1 
                   INNER join PriceKgBean p on p.id = o.priceKgBean.id where e.id= :id 
                   """)
    List<OrdenDto> findByOrderBeansOrderById(@Param("id") Long id);

    @Query("""
                   SELECT new  utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto (e.id , p.name,e.email,p.lastName,r.type,p.urlPhoto,p.phone,sp.type ,p.sex)
                  FROM PersonBean p
                   inner join EmployeesBean e on p.id=e.personBean.id and e.id =:id
                   inner join RolsBean r on e.rolsBean.id = r.id 
                    inner join StatusPersonBean sp on sp.id = p.statusPersonBean.id
                    
                   """)
    Optional<EmployeesDto> getEmployeeId(@Param("id") Long id);

    @Query ("""  
  SELECT new utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto(e.id , p.name,e.email,p.lastName,r.type,p.urlPhoto,p.phone,sp.type) FROM PersonBean p inner join EmployeesBean e on p.id=e.personBean.id inner join RolsBean r
   on e.rolsBean.id = r.id inner join StatusPersonBean sp on sp.id = p.statusPersonBean.id""")
    List<EmployeesDto> findAllEmployeesDto();


    @Query("""
            SELECT new utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto (e.id, p.name, e.email, p.lastName, COUNT(o.id))
            FROM EmployeesBean e
                     INNER JOIN PersonBean p ON p.id = e.personBean.id
                     INNER JOIN RolsBean r ON r.id = e.rolsBean.id AND r.id = 2 
                     LEFT JOIN OrderBean o ON o.employeesBean.id = e.id 
                     INNER JOIN StatusBean s ON s.id = o.statusBean.id AND s.id = 3
            GROUP BY e.id, p.name, e.email, p.lastName
            UNION
            SELECT new utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto  (e.id, p.name, e.email, p.lastName, 0 )
            FROM EmployeesBean e
                     INNER JOIN PersonBean p ON p.id = e.personBean.id
                     INNER JOIN RolsBean r ON r.id = e.rolsBean.id AND r.id = 2
            WHERE NOT EXISTS (
                SELECT 1
                FROM OrderBean o
                WHERE o.employeesBean.id = e.id
            )
            """)
    List<EmployeesDto> findAllForOrdens();



}
