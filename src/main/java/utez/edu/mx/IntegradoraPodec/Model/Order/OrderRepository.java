package utez.edu.mx.IntegradoraPodec.Model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderBean,Long> {
    Optional<OrderBean> findById (Long id);

    @Query("""
    Select  new  utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto(o.id , p.name,p.lastName,c.email  , count(oi.orderBean.id) , SUM((pk.priceSale + e.price)  * oi.quantity) ) FROM
        OrderBean o
            inner join CustomersBean  c on c.id = o.customersBean.id
            inner join PersonBean p on p.id = c.personBean.id
            inner join PriceKgBean pk on o.priceKgBean.id = pk.id
            inner join StatusBean st on st.id  = 3 and o.statusBean.id = st.id
            inner join OrderItemBean  oi on o.id = oi.orderBean.id
            inner join ProductExtrasBean pe on oi.productExtrasBean.id = pe.id
            inner join ExtrasBean e on pe.extrasBean.id = e.id
            group by o.id, p.name, p.lastName, c.email
    
""")
    List<OrdenDto> getAllFast();
    @Query("""
    Select  new  utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto(o.id , p.name,p.lastName,c.email  , count(oi.orderBean.id) , SUM((pk.priceSale + e.price)  * oi.quantity)  , o.dateRequest ,  s.type , s.description) FROM
        OrderBean o
            inner join CustomersBean  c on c.id = o.customersBean.id and c.id = :idCustomer
            inner join PersonBean p on p.id = c.personBean.id
            inner join PriceKgBean pk on o.priceKgBean.id = pk.id
            inner join OrderItemBean  oi on o.id = oi.orderBean.id
            inner join StatusBean s on o.statusBean.id = s.id
            inner join ProductExtrasBean pe on oi.productExtrasBean.id = pe.id
            inner join ExtrasBean e on pe.extrasBean.id = e.id
            group by o.id, p.name, p.lastName, c.email , o.dateRequest,s.type , s.description
    
""")
    List<OrdenDto> getAllFastForCustomer(@Param("idCustomer") Long idCustomer);
    @Query("""
       Select  new  utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto(o.id , p.name,p.lastName,c.email  , count(oi.orderBean.id) , SUM((pk.priceSale + e.price)  * oi.quantity)  , o.latitude , o.longitude , pk.priceSale) FROM
           OrderBean o
               inner join CustomersBean  c on c.id = o.customersBean.id
               inner join PersonBean p on p.id = c.personBean.id
               inner join PriceKgBean pk on o.priceKgBean.id = pk.id
               inner join StatusBean st on st.id  = 2 and o.statusBean.id = st.id
               inner join OrderItemBean  oi on o.id = oi.orderBean.id
               inner join ProductExtrasBean pe on oi.productExtrasBean.id = pe.id
               inner join ExtrasBean e on pe.extrasBean.id = e.id
               WHERE :idEmployees = o.employeesBean.id
               group by o.id, p.name, p.lastName, c.email 
""")
    List<OrdenDto> getAllFastForEmployees(@Param("idEmployees") Long idEmployees);


    @Query("""
select new  utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto (p.name , p.urlPhoto , p.description , e.name ,e.description , oi.quantity  , oi.price) from OrderBean o
inner join OrderItemBean oi on o.id = oi.orderBean.id
inner join ProductExtrasBean pe on oi.productExtrasBean.id = pe.id
inner join ExtrasBean e on pe.extrasBean.id = e.id
inner join ProductBean p on pe.productBean.id = p.id
where o.id  = :idOrder

""")
    List<OrdenDto> getAllProduct (@Param("idOrder") Long idOrder)  ;
}
