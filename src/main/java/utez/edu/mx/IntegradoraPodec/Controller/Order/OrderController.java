package utez.edu.mx.IntegradoraPodec.Controller.Order;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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



    @PostMapping("/readAllForOrder")
    public ResponseEntity<ApiResponse> getAllForOrder(@RequestBody OrderDto dto)
    {return service.getAllForOrder(dto.getId());}

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

    @PutMapping("/updateEmployees")
    public ResponseEntity<ApiResponse> updateEmployees
            (@RequestBody OrderDto dto){
        return service.update(dto.getId(),dto.getIdEmployee());
    }
    @PutMapping("/finish")
    public ResponseEntity<ApiResponse> finish
            (@RequestBody OrderDto dto){
        return service.finish(dto.toEntityId());
    }
    @PutMapping("/refused")
    public ResponseEntity<ApiResponse> refused
            (@RequestBody OrderDto dto){
        return service.refused(dto.toEntityId());
    }

    //Leer general
    @GetMapping("/readAll")
    public ResponseEntity<ApiResponse> getAll()
    {return service.getAll();}

    @PostMapping("/readAllForCustomer")
    public ResponseEntity<ApiResponse> getAll(@RequestBody OrderDto dto)
    {return service.getAllFastForCustomer(dto.getIdCustomer());}


    @PostMapping("/readAllForEmployees")
    public ResponseEntity<ApiResponse> getAllForEmlployees(@RequestBody OrderDto dto)
    {return service.getAllForEmployees(dto.getIdEmployee());}

    @PutMapping("/remove")
    public ResponseEntity<ApiResponse> removeById(@RequestBody OrderDto dto){
        return service.removeById(dto.getId());
    }

    //eliminar
    @DeleteMapping("/delete{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }
}

