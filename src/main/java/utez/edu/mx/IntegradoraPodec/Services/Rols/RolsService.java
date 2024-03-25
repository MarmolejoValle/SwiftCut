package utez.edu.mx.IntegradoraPodec.Services.Rols;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Data
public class RolsService {
    private final RolsRepository repository;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<RolsBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, "Rol encontrado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, "No se encontro el rol"), HttpStatus.NOT_FOUND);
        }
    }
    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<RolsBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Rol eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Rol no existente"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.readAllByIdAndType(), HttpStatus.OK,"Rol encontrado"),
                HttpStatus.OK);
    }

    // SELECT * FROM WHERE ID
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getId(RolsBean object){
        Optional<RolsBean> foundObject = repository.findById(object.getId());
        if(foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.findById(object.getId()),HttpStatus.OK, "Rol encontrado"), HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true, "Rol no encontrado"),HttpStatus.BAD_REQUEST);
    }

    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(RolsBean object){
        return new ResponseEntity<>(new ApiResponse(
                repository.saveAndFlush(object),HttpStatus.OK,"Rol creado"),HttpStatus.OK);
    }

    // UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(RolsBean objects){
        Optional<RolsBean>foundObject = repository.findById(objects.getId());
        if (foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(objects),HttpStatus.OK,"Rol actualizado"), HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true, "Rol invalido"),HttpStatus.BAD_REQUEST);
    }
}
