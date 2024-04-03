package utez.edu.mx.IntegradoraPodec.Controller.PriceKg;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.PriceKg.dto.PriceKgDto;
import utez.edu.mx.IntegradoraPodec.Services.Price_Kg.PriceKgService;

@RestController
@RequestMapping("/api/priceKg")
@CrossOrigin(origins={"*"})
@AllArgsConstructor
public class PriceKgController {
    private final PriceKgService service;

    //Crear
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> save(@RequestBody PriceKgDto dto){
        return  service.save(dto.toEntity());
    }

    //Leer
    @GetMapping("/readNow")
    public ResponseEntity<ApiResponse> getById() {
        return service.getNow();
    }


    //Actualizar


    //Leer general
    @GetMapping("/readAll")
    public ResponseEntity<ApiResponse> getAll()
    {return service.getAll();}

    //eliminar

}
