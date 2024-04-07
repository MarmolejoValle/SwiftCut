package utez.edu.mx.IntegradoraPodec.Controller.Customer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Category.dto.CategoryDto;
import utez.edu.mx.IntegradoraPodec.Controller.Customer.dto.CustomerDto;
import utez.edu.mx.IntegradoraPodec.Controller.DtoShare.CustomerPerson;
import utez.edu.mx.IntegradoraPodec.Services.Customer.CustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class CustomerController {
    private final CustomerService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@ModelAttribute  CustomerPerson dto){
        return  service.save(dto.toEntity(),dto.toFile());
    }

    //Leer
    @PostMapping("/read")
    public ResponseEntity<ApiResponse> getById(@RequestBody CustomerDto dto) {
        return service.findById(dto.getId());

    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@ModelAttribute  CustomerPerson dto){
        return service.update(dto.toEntityId() , dto.toFile());
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
