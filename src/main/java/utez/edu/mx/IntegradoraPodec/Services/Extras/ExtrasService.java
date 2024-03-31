package utez.edu.mx.IntegradoraPodec.Services.Extras;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.Extras.dto.ExtrasDto;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtraDto;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Data
public class ExtrasService {
    private final ExtrasRepository repository;
    //FALTAN LOS MENSAJES
    //Leer (Consulta individual)
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<ExtrasBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, "Extra encontrado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, "El extra no se encontro"), HttpStatus.NOT_FOUND);
        }
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findByForExtrasProduct(Long id){
        List<ExtraDto> object = repository.findByExtrasForProduct(id);

            return new ResponseEntity<>(new ApiResponse(object, HttpStatus.OK, "Extra encontrado"), HttpStatus.OK);

    }
    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<ExtrasBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse("",HttpStatus.OK, false, "Extra eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Extra no encontrado"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAllFast(), HttpStatus.OK,"Extra encontrado"),
                HttpStatus.OK);
    }
    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(ExtrasBean object){
        return new ResponseEntity<>(new ApiResponse(
                repository.saveAndFlush(object),HttpStatus.OK,"Extra creado"),HttpStatus.OK);
    }


    // UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(ExtrasBean objects){
        Optional<ExtrasBean>foundObject = repository.findById(objects.getId());

        foundObject.get().setName(objects.getName());
        foundObject.get().setPrice(objects.getPrice());
        foundObject.get().setDescription(objects.getDescription());



        if (foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(objects),HttpStatus.OK,"Extra actualizado"), HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true, "Extra del carrito invalido"),HttpStatus.BAD_REQUEST);
    }
}

