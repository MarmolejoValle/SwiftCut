package utez.edu.mx.IntegradoraPodec.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryBean,Long> {

    @Query("""
    Select new utez.edu.mx.IntegradoraPodec.Model.Category.CategoryDto(c.id , c.description , c.name,c.urlPhoto) from CategoryBean  c 
""")
    List<CategoryDto> findByAllFast();
}
