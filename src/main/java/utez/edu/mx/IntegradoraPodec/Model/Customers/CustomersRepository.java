package utez.edu.mx.IntegradoraPodec.Model.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersBean,Long> {



}
