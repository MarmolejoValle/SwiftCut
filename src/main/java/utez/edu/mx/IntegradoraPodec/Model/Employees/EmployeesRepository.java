package utez.edu.mx.IntegradoraPodec.Model.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesBean,Long> {
    Optional<EmployeesBean> findById (Long id);
}
