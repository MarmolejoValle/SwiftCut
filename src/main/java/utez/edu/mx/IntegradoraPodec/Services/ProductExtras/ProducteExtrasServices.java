package utez.edu.mx.IntegradoraPodec.Services.ProductExtras;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Controller.DtoShare.CategoryProductsDto;
import utez.edu.mx.IntegradoraPodec.Model.Extras.ExtrasRepository;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductRepository;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasBean;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasDto;
import utez.edu.mx.IntegradoraPodec.Model.ProductExtras.ProductExtrasRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Data
public class ProducteExtrasServices {
    private final ProductExtrasRepository productExtrasRepository ;
    private final ProductRepository productRepository;
    private final ExtrasRepository extrasRepository;
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> addProductExtra(ProductExtrasBean object){
        Optional<ProductExtrasDto> productExtrasDto = productExtrasRepository.findByProductAndExtra(object.getProductBean().getId(), object.getExtrasBean().getId());
        if (!productExtrasDto.isPresent()){
            ProductExtrasBean bean = new ProductExtrasBean();
            bean.setProductBean(productRepository.findById(object.getProductBean().getId()).get());
            bean.setExtrasBean(extrasRepository.findById(object.getExtrasBean().getId()).get());

            productExtrasRepository.saveAndFlush(bean);
            return new ResponseEntity<>(new ApiResponse(object, HttpStatus.OK, "Producto  registado"), HttpStatus.OK);

        }


        return new ResponseEntity<>(new ApiResponse(object, HttpStatus.BAD_REQUEST, "El Producto estaba registado"), HttpStatus.BAD_REQUEST);


    }
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteProductExtra(Long  id){
        Optional<ProductExtrasBean> productExtrasBean = productExtrasRepository.findById(id);
        if (productExtrasBean.isPresent()){

            productExtrasRepository.delete(productExtrasBean.get());
            return new ResponseEntity<>(new ApiResponse("", HttpStatus.OK, "Eliminado  registado"), HttpStatus.OK);

        }


        return new ResponseEntity<>(new ApiResponse("", HttpStatus.BAD_REQUEST, "El Producto no se pudo eliminar"), HttpStatus.BAD_REQUEST);


    }
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> getExtras(ProductExtrasBean object){
        List<ProductExtrasDto> productExtrasDto = productExtrasRepository.findByExtras(object.getProductBean().getId());


            return new ResponseEntity<>(new ApiResponse(productExtrasDto, HttpStatus.OK, "Productos encontrados"), HttpStatus.OK);



    }
    @Transactional(rollbackFor = {SQLException.class})
    public ProductExtrasBean findProductExtraForProduct(Long idProduct){
        Optional<ProductExtrasDto> productExtrasDto = productExtrasRepository.findProductExtrasForProduct(idProduct);

        if (productExtrasDto.isPresent())
        {
            Optional<ProductExtrasBean> extrasBean = productExtrasRepository.findById(productExtrasDto.get().getId());
            System.out.println("Producto encontrado");
            return extrasBean.get();

        }

        return null;



    }


}
