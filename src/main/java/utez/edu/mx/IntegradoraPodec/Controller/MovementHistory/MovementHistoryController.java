package utez.edu.mx.IntegradoraPodec.Controller.MovementHistory;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.MovementHistory.dto.MovementHistoryDto;
import utez.edu.mx.IntegradoraPodec.Services.Movement_History.MovementHistoryService;

@RestController
@RequestMapping("/api/movementHistory")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class MovementHistoryController {
    private final MovementHistoryService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody MovementHistoryDto dto){
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
    (@RequestBody MovementHistoryDto dto){
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

