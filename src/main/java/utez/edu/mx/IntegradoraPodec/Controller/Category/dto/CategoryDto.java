package utez.edu.mx.IntegradoraPodec.Controller.Category.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Category.CategoryBean;

@Data
@Getter
@Setter
public class CategoryDto {

    private Long id;

    private String name;

    private String description;
    private MultipartFile image;

    public CategoryBean toEntityId(){
        return new CategoryBean(id,name, description) ;
    }
    public CategoryBean toEntity(){
        return new CategoryBean(name, description);
    }
    public MultipartFile toFile(){return image ;
    }
}
