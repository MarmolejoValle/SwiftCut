package utez.edu.mx.IntegradoraPodec.Controller.MovementType;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.MovementType.dto.MovementTypeDto;
import utez.edu.mx.IntegradoraPodec.Services.MovementType.MovementTypeService;

@RestController
@RequestMapping("/api/movementType")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class MovementTypeController {
    private final MovementTypeService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody MovementTypeDto dto){
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
    (@RequestBody MovementTypeDto dto){
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