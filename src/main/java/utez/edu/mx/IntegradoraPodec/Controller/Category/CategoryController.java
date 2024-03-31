package utez.edu.mx.IntegradoraPodec.Controller.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Category.dto.CategoryDto;
import utez.edu.mx.IntegradoraPodec.Services.Category.CategoryService;

@Data
@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins={"*"})
@AllArgsConstructor

public class CategoryController {
    private final CategoryService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@ModelAttribute CategoryDto dto){
        return  service.save(dto.toEntity() , dto.toFile());
    }

    //Leer
    @GetMapping("/read{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update(@ModelAttribute CategoryDto dto){
        return service.update(dto.toEntityId(), dto.getImage());
    }

    //Leer general
    @GetMapping("/readAll")
    public ResponseEntity<ApiResponse> getAll()
    {return service.getAll();}

    //eliminar
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteById(@RequestBody CategoryDto dto){
        return service.deleteById(dto.getId());
    }
}
