package utez.edu.mx.IntegradoraPodec.Model.Movement_History;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementHistoryRepository  extends JpaRepository<MovementHistoryBean,Long> {
}
