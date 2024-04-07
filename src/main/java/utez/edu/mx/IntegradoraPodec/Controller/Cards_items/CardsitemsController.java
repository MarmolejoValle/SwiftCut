package utez.edu.mx.IntegradoraPodec.Controller.Cards_items;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Cards_items.dto.Cards_itemsDto;
import utez.edu.mx.IntegradoraPodec.Services.Cards_items.CardsItemsService;

@Data
@RestController
@RequestMapping("/api/cardsitems")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class CardsitemsController {
    private final CardsItemsService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody Cards_itemsDto dto){
        return  service.save(dto.toEntityAdd());
    }

    //Leer
    @GetMapping("/read{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PostMapping("/readForShop")
    public ResponseEntity<ApiResponse> readForShop(@RequestBody  Cards_itemsDto dto) {
        return service.getAllForCarShop(dto.getId());
    }

    //Actualizar
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update
    (@RequestBody Cards_itemsDto dto){
        return service.update(dto.toEntityId());
    }

    //Leer general
    @GetMapping("/readAll")
    public ResponseEntity<ApiResponse> getAll()
    {return service.getAll();}

    //eliminar
    @PostMapping("/delete")
    public ResponseEntity<ApiResponse> deleteById(@RequestBody Cards_itemsDto dto){
        return service.deleteById(dto.getId());
    }
}
