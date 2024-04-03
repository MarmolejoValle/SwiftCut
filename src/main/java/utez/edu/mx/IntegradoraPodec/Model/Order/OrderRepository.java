package utez.edu.mx.IntegradoraPodec.Model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderBean,Long> {
    Optional<OrderBean> findById (Long id);

    @Query("""
    Select new  utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto(o.id , p.name,p.lastName,c.email ) FROM 
    OrderBean o 
    inner join CustomersBean  c on c.id = o.customersBean.id
    inner join PersonBean p on p.id = c.personBean.id
    inner join StatusBean st on st.id  = 3 and o.statusBean.id = st.id
""")
    List<OrdenDto> getAllFast();
}
