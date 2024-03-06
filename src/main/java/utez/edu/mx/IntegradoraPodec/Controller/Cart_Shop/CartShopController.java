package utez.edu.mx.IntegradoraPodec.Controller.Cart_Shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Cart_Shop.dto.Cart_ShopDto;
import utez.edu.mx.IntegradoraPodec.Services.Cart_Shop.CartShopService;

@Data
@RestController
@RequestMapping("/api/cartshop")
@CrossOrigin(origins={"*"})
@AllArgsConstructor

public class CartShopController {
    private final CartShopService service;

    //Crear
    /*@PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody Cart_ShopDto dto){
        return  service.save(dto.toEntityId());
    }*/

    //Leer
    @GetMapping("/read{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@RequestBody Cart_ShopDto dto){
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
