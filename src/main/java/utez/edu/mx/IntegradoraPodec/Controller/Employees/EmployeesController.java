package utez.edu.mx.IntegradoraPodec.Controller.Employees;

import com.google.api.client.http.HttpMediaType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.DtoShare.EmployeesPersonDto;
import utez.edu.mx.IntegradoraPodec.Controller.Employees.dto.EmployeesDto;
import utez.edu.mx.IntegradoraPodec.Services.Employees.EmployeesService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class EmployeesController {
    private final EmployeesService service;

    //Crear

    @PostMapping(value = "/add")
    public ResponseEntity<ApiResponse> save(@ModelAttribute EmployeesPersonDto dto) throws IOException {

        return  service.save(dto.toEntity(),dto.toFile());
    }

    //Leer
    @PostMapping("/readEmployeeId")
    public ResponseEntity<ApiResponse> getEmployee(@RequestBody EmployeesDto dto){
       return service.getEmployeeId(dto.toEntityId().getId());
    }
    @PostMapping("/info")
    public ResponseEntity<ApiResponse> getEmployeeEmail(@RequestBody EmployeesDto dto){
        return service.getEmployeeEmail(dto.toEntityId().getEmail());
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
    @PutMapping(value = "/update")
    public ResponseEntity<ApiResponse> update(@ModelAttribute EmployeesPersonDto dto) throws IOException {

        return  service.update(dto.toEntityId(),dto.toFile());
    }

    //Leer general
    @GetMapping("/readAll")
    public ResponseEntity<ApiResponse> getAll()
    {return service.getAll();}
    @GetMapping("/readForOrdens")
    public ResponseEntity<ApiResponse> getForOrdens()
    {return service.getAllForOrdens();}

    //eliminar
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteById(@RequestBody EmployeesDto dto){
        return service.deleteById(dto.getId());
    }
}
