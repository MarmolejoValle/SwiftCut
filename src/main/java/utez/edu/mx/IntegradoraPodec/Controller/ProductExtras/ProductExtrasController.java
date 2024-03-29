package utez.edu.mx.IntegradoraPodec.Controller.ProductExtras;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Product.dto.ProductDto;
import utez.edu.mx.IntegradoraPodec.Controller.ProductExtras.dto.ProductExtrasDto;
import utez.edu.mx.IntegradoraPodec.Services.Product.ProductService;
import utez.edu.mx.IntegradoraPodec.Services.ProductExtras.ProducteExtrasServices;

@RestController
@RequestMapping("/api/productExtras")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class ProductExtrasController {
    private final ProducteExtrasServices service;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> updateProductExtra(@RequestBody ProductExtrasDto dto) {
        return service.addProductExtra(dto.toEntity());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteProductExtra(@RequestBody ProductExtrasDto dto) {
        return service.deleteProductExtra(dto.getId());
    }

    @PostMapping("/readExtras")
    public ResponseEntity<ApiResponse> getExtras(@RequestBody ProductExtrasDto dto) {
        return service.getExtras(dto.toEntityExtra());
    }
}
