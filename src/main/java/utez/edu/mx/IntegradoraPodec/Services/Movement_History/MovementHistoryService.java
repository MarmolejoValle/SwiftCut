package utez.edu.mx.IntegradoraPodec.Services.Movement_History;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryRepository;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgBean;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgDto;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Data
public class MovementHistoryService {
    private final MovementHistoryRepository repository;
    private final PriceKgRepository priceKgRepository ;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<MovementHistoryBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, "Historial de movimiento encontrrado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, "No se encontro el historial de movimiento"), HttpStatus.NOT_FOUND);
        }
    }
    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<MovementHistoryBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Historial de movimiento eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Historial de movimiento no existente"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        PriceKgDto kgDto = priceKgRepository.findNullPriceKg().get();
        return new ResponseEntity<>(new ApiResponse(repository.getAll(kgDto.getId()), HttpStatus.OK,"Historial de movimiento encontrado"),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> categoryData(){
        PriceKgDto kgDto = priceKgRepository.findNullPriceKg().get();

        return new ResponseEntity<>(new ApiResponse(repository.categoryData(kgDto.getId()), HttpStatus.OK,"Historial de movimiento encontrado"),
                HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> quantityCategory(){
        PriceKgDto kgDto = priceKgRepository.findNullPriceKg().get();

        return new ResponseEntity<>(new ApiResponse(repository.quantityCategory(kgDto.getId()), HttpStatus.OK,"Historial de movimiento encontrado"),
                HttpStatus.OK);
    }





    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(MovementHistoryBean object){
        return new ResponseEntity<>(new ApiResponse(
                repository.saveAndFlush(object),HttpStatus.OK,"Historial de movimiento creado"),HttpStatus.OK);
    }

    // UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(MovementHistoryBean objects){
        Optional<MovementHistoryBean>foundObject = repository.findById(objects.getId());
        if (foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(objects),HttpStatus.OK,"Historial de movimiento actualizado"), HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true, "Historial de movimiento invalido"),HttpStatus.BAD_REQUEST);
    }


    @Transactional(rollbackFor = {SQLException.class})
    public void addMovement(MovementHistoryBean historyBean){






    }


}
