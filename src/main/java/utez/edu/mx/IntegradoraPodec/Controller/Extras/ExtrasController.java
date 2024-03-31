package utez.edu.mx.IntegradoraPodec.Controller.Extras;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Extras.dto.ExtrasDto;
import utez.edu.mx.IntegradoraPodec.Services.Extras.ExtrasService;

@RestController
@RequestMapping("/api/extras")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class ExtrasController {
    private final ExtrasService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody ExtrasDto dto){
        return  service.save(dto.toEntity());
    }

    //Leer
    @PostMapping("/read")
    public ResponseEntity<ApiResponse> getById(@RequestBody ExtrasDto dto) {

        return service.findById(dto.getId());
    }
    @PostMapping("/readForProduct")
    public ResponseEntity<ApiResponse> getByForProduct(@RequestBody ExtrasDto dto) {

        return service.findByForExtrasProduct(dto.getId());
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@RequestBody ExtrasDto dto){
        return service.update(dto.toEntityId());
    }

    //Leer general
    @GetMapping("/readAll")
    public ResponseEntity<ApiResponse> getAll()
    {return service.getAll();}

    //eliminar
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteById(@RequestBody ExtrasDto dto){
        return service.deleteById(dto.getId());
    }




}
