package utez.edu.mx.IntegradoraPodec.Services.Price_Kg;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgBean;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgRepository;

import java.sql.SQLException;
import java.util.Optional;

@Data
@Service
@Transactional
@AllArgsConstructor
public class PriceKgService {
    private final PriceKgRepository repository;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<PriceKgBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, "Precio por kilo encontrado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, "Precio por kilo no encontrado"), HttpStatus.NOT_FOUND);
        }
    }
    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<PriceKgBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Precio por kilo Eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Precio por kilo no encontrado"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,"Precios por kilos obtenidos"),
                HttpStatus.OK);
    }

    // SELECT * FROM WHERE ID
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getId(PriceKgBean object){
        Optional<PriceKgBean> foundObject = repository.findById(object.getId());
        if(foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.findById(object.getId()),HttpStatus.OK,
                    "Precio por kilo  encontrado"),
                    HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                "Precio por kilo no encontrado"),HttpStatus.BAD_REQUEST);
    }

    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(PriceKgBean object){
        return new ResponseEntity<>(new ApiResponse(
                repository.saveAndFlush(object),HttpStatus.OK,"Precio por kilo creado"),HttpStatus.OK);
    }

    // UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(PriceKgBean objects){
        Optional<PriceKgBean>foundObject = repository.findById(objects.getId());
        if (foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(objects),HttpStatus.OK,"Precio por kilo actulizado"),
                    HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                "Precio por kilo  no encontrado"),HttpStatus.BAD_REQUEST);
    }
}
