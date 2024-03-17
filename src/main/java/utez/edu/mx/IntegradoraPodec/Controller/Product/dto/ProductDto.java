package utez.edu.mx.IntegradoraPodec.Controller.Product.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;

@Data
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String quantity;
    private MultipartFile file;

    public ProductBean toEntity(){
        return new ProductBean(name, description,quantity);
    }


    public MultipartFile toFile(){
        return file;
    }
    public ProductBean toEntityId(){
        return new ProductBean(id, name, description,quantity) ;
    }
}
