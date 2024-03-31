package utez.edu.mx.IntegradoraPodec.Controller.Order;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Order.dto.OrderDto;
import utez.edu.mx.IntegradoraPodec.Services.Order.OrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody OrderDto dto){
        return  service.save(dto.getIdCarShop() , dto.getLatitue() ,dto.getLongitude());
    }

    //Leer
    @GetMapping("/read{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@RequestBody OrderDto dto){
        return service.update(dto.getId(),dto.getIdEmployee());
    }
    @PutMapping("/updateEmployees")
    public ResponseEntity<ApiResponse> updateEmployees
            (@RequestBody OrderDto dto){
        return service.update(dto.getId(),dto.getIdEmployee());
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

