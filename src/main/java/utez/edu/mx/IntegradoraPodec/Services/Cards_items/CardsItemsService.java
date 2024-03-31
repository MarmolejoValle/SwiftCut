package utez.edu.mx.IntegradoraPodec.Services.Cards_items;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CardsItemsDto;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CardsItemsRepository;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CartShopRepository;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Data
public class CardsItemsService{
    private final CardsItemsRepository repository;
    private final ProductExtrasRepository productExtrasRepository;
    private final CartShopRepository shopRepository ;

    //Leer (Consulta individual)
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<CarsItemsBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, "Articulo del carrito encontrado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, "No se encontró el articulo del carrito"), HttpStatus.NOT_FOUND);
        }
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAllForCarShop(Long id){
        List<CardsItemsDto> object = repository.getAllForCarShop(id);

            return new ResponseEntity<>(new ApiResponse(object, HttpStatus.OK, "Articulo del carrito encontrado"), HttpStatus.OK);

    }

    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<CarsItemsBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Articulo del carrito  eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Articulo del carrito no existente"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,"Articulos del carrito encontrado"), HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAllForCardShop(Long id){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK,"Articulos del carrito encontrado"), HttpStatus.OK);
    }

    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(CarsItemsBean object){
        Optional<ProductExtrasBean>  productExtrasBean = productExtrasRepository.findById(object.getProductExtrasBean().getId());
        Optional<CarShopBean> carShopBean = shopRepository.findById(object.getCarShopBean().getId());

        object.setCarShopBean(carShopBean.get());
        object.setProductExtrasBean(productExtrasBean.get());
        repository.saveAndFlush(object);
        return new ResponseEntity<>(new ApiResponse(
                "",HttpStatus.OK,"Articulo del carrito creado"),HttpStatus.OK);
    }

    // UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(CarsItemsBean objects){
        Optional<CarsItemsBean>foundObject = repository.findById(objects.getId());
        if (foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(objects),HttpStatus.OK,"Articulo del carrito actualizado"), HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true, "Articulo del carrito invalido"),HttpStatus.BAD_REQUEST);
    }


}
