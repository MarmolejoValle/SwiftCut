package utez.edu.mx.IntegradoraPodec.Services.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Status.StatusBean;
import utez.edu.mx.IntegradoraPodec.Model.Status.StatusRepository;

import java.sql.SQLException;
import java.util.Optional;

@Data
@Service
@AllArgsConstructor
@Transactional
public class StatusService {
    private final StatusRepository repository;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<StatusBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, ""), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, ""), HttpStatus.NOT_FOUND);
        }
    }
    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<StatusBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Registro Eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Registro No encontrado"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,""),
                HttpStatus.OK);
    }

    // SELECT * FROM WHERE ID
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getId(StatusBean object){
        Optional<StatusBean> foundObject = repository.findById(object.getId());
        if(foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.findById(object.getId()),HttpStatus.OK,
                    "Registro Encontrado"),
                    HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                "Registro No encontrado"),HttpStatus.BAD_REQUEST);
    }

    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(StatusBean object){

        return new ResponseEntity<>(new ApiResponse(
                repository.saveAndFlush(object),HttpStatus.OK,"Status creado"),HttpStatus.OK);
    }

    // UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(StatusBean objects){
        Optional<StatusBean>foundObject = repository.findById(objects.getId());
        if (foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(objects),HttpStatus.OK,""),
                    HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                ""),HttpStatus.BAD_REQUEST);
    }
}
