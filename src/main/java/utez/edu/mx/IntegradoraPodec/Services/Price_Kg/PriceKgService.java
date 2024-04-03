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
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgDto;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
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


    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,"Precios por kilos obtenidos"),
                HttpStatus.OK);
    }

    // SELECT * FROM WHERE ID
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getNow(){
        Optional<PriceKgDto> foundObject = repository.findNullPriceKg();
        if(foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(foundObject.get(),HttpStatus.OK,
                    "Precio por kilo  encontrado"),
                    HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                "Precio por kilo no encontrado"),HttpStatus.BAD_REQUEST);
    }
    @Transactional(readOnly = true)
    public PriceKgBean getBeanNow(){
        PriceKgDto kgDto = repository.findNullPriceKg().get();
        return repository.findById(kgDto.getId()).get();
    }


    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(PriceKgBean object){
        PriceKgDto kgDto =  repository.findNullPriceKg().get();
        PriceKgBean kgBean = repository.findById(kgDto.getId()).get();
        kgBean.setDateEnd(LocalDateTime.now());
        PriceKgBean priceKgBean = new PriceKgBean(LocalDateTime.now(),object.getPriceBuy(),object.getPriceSale());
       repository.saveAndFlush(kgBean);
        repository.saveAndFlush(priceKgBean);

        return new ResponseEntity<>(new ApiResponse(priceKgBean
                ,HttpStatus.OK,"Precio por kilo creado"),HttpStatus.OK);
    }

    // UPDATE

}
