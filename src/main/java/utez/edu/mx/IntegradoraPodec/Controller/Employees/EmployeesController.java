package utez.edu.mx.IntegradoraPodec.Controller.Employees;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Employees.dto.EmployeesDto;
import utez.edu.mx.IntegradoraPodec.Services.Employees.EmployeesService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class EmployeesController {
    private final EmployeesService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody EmployeesDto dto){
        return  service.save(dto.toEntity());
    }

    //Leer
    @PostMapping("/readEmployeeId")
    public ResponseEntity<ApiResponse> getEmployee(@RequestBody EmployeesDto dto){
       return service.getEmployeeId(dto.toEntityId().getId());
    }
    @PostMapping ("/countOrdens")
    public ResponseEntity<ApiResponse> getCountOrdens (@RequestBody EmployeesDto dto) {
        return service.getCountOrdens(dto.toEntityId().getId());
    }
    @PostMapping ("/Ordens")
    public ResponseEntity<ApiResponse> getOrdens (@RequestBody EmployeesDto dto) {
        return service.getOrdens(dto.toEntityId().getId());
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@RequestBody EmployeesDto dto){
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
