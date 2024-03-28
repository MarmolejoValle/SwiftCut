package utez.edu.mx.IntegradoraPodec.Services.ProductExtras;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.DtoShare.CategoryProductsDto;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Data
public class ProducteExtrasServices {
    private final ProductExtrasRepository productExtrasRepository ;

}
