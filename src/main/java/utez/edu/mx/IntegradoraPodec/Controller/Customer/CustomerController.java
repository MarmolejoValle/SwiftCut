package utez.edu.mx.IntegradoraPodec.Controller.Customer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Category.dto.CategoryDto;
import utez.edu.mx.IntegradoraPodec.Controller.Customer.dto.CustomerDto;
import utez.edu.mx.IntegradoraPodec.Services.Customer.CustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class CustomerController {
    private final CustomerService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody CustomerDto dto){
        return  service.save(dto.toEntity());
    }

    //Leer
    @GetMapping("/read{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@RequestBody CustomerDto dto){
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
