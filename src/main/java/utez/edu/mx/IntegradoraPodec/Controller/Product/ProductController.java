package utez.edu.mx.IntegradoraPodec.Controller.Product;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Product.dto.ProductDto;
import utez.edu.mx.IntegradoraPodec.Services.Product.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins={"*"})
@AllArgsConstructor

public class ProductController {
    private final ProductService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@ModelAttribute ProductDto dto){
        return  service.save(dto.toEntity() ,dto.toFile());
    }

    //Leer
    @GetMapping("/read{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@RequestBody ProductDto dto){
        return service.update(dto.toEntityId());
    }

    //Leer general
    @GetMapping("/readAll")
    public ResponseEntity<ApiResponse> getAll()
    {return service.getAll();}

    //eliminar
    @DeleteMapping("/delete{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }
}
