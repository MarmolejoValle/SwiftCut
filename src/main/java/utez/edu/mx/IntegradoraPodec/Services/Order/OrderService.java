package utez.edu.mx.IntegradoraPodec.Services.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CardsItemsRepository;
import utez.edu.mx.IntegradoraPodec.Model.Cards_items.CarsItemsBean;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CartShopRepository;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesRepository;
import utez.edu.mx.IntegradoraPodec.Model.MovementType.MovementTypeBean;
import utez.edu.mx.IntegradoraPodec.Model.MovementType.MovementTypeRepository;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryBean;
import utez.edu.mx.IntegradoraPodec.Model.Movement_History.MovementHistoryRepository;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderBean;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrderRepository;
import utez.edu.mx.IntegradoraPodec.Model.Order_Item.OrderItemBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Price_Kg.PriceKgBean;
import utez.edu.mx.IntegradoraPodec.Model.Status.StatusRepository;
import utez.edu.mx.IntegradoraPodec.Services.Cards_items.CardsItemsService;
import utez.edu.mx.IntegradoraPodec.Services.Price_Kg.PriceKgService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
@Data
public class OrderService {
    private final OrderRepository repository;
    private final EmployeesRepository employeesRepository;
    private final CartShopRepository cartShopRepository ;
    private final CardsItemsRepository itemsRepository ;
    private final CardsItemsService itemsService;
    private final StatusRepository statusRepository ;
    private final PriceKgService priceKgService ;
    private final MovementTypeRepository movementTypeRepository;
    private final MovementHistoryRepository movementHistoryRepository;
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<OrderBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, "Order encontrado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, "Order no encontrado"), HttpStatus.NOT_FOUND);
        }
    }
    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<OrderBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Order Eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Order No encontrado"), HttpStatus.NOT_FOUND);
    }
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> removeById(Long id) {
        Optional<OrderBean> opt = repository.findById(id);
        if (opt.isPresent()){
            opt.get().setStatusBean(statusRepository.findById(3L).get());
            opt.get().setEmployeesBean(null);
            opt.get().setDateSending(null);

            repository.saveAndFlush(opt.get());
            return  new ResponseEntity<>(new ApiResponse("",HttpStatus.OK, "Order Eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Order No encontrado"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.getAllFast(), HttpStatus.OK,"Ordenes"),
                HttpStatus.OK);
    }
    public ResponseEntity<ApiResponse> getAllForEmployees(Long idEmployees){
        return new ResponseEntity<>(new ApiResponse(repository.getAllFastForEmployees(idEmployees), HttpStatus.OK,"Ordenes del empleado"),
                HttpStatus.OK);
    }

    // SELECT * FROM WHERE ID
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getId(OrderBean object){
        Optional<OrderBean> foundObject = repository.findById(object.getId());
        if(foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse(repository.findById(object.getId()),HttpStatus.OK,
                    "Order Encontrado"),
                    HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                "Order No encontrado"),HttpStatus.BAD_REQUEST);
    }

    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(Long idCarShop , String latitue , String longitude){

        Optional<CarShopBean> carShopBean = cartShopRepository.findById(idCarShop);

        if (carShopBean.isPresent()) {
            OrderBean orderBean = new OrderBean();
            orderBean.setLatitude(latitue);
            orderBean.setLongitude(longitude);
            orderBean.setDateRequest(LocalDate.now());
            orderBean.setStatusBean(statusRepository.findById(3L).get());
            PriceKgBean priceKgBeans =  priceKgService.getBeanNow();
            orderBean.setPriceKgBean(priceKgBeans);
            Set<OrderItemBean> orderItemBeanSet= new HashSet<OrderItemBean>();
            orderBean.setCustomersBean(carShopBean.get().getCustomersBean());

            Set<CarsItemsBean> carsItemsBeanList = carShopBean.get().getCarsItemsBeans();
            carsItemsBeanList.forEach(carsItemsBean -> {
                 OrderItemBean itemBean = new OrderItemBean();
                 itemBean.setQuantity(carsItemsBean.getQuantity());
                 itemBean.setProductExtrasBean(carsItemsBean.getProductExtrasBean());
                 itemBean.setPrice(0);
                 orderItemBeanSet.add(itemBean);
                 itemBean.setOrderBean(orderBean);

            });

            orderBean.setOrderItemBeans(orderItemBeanSet);
            repository.saveAndFlush(orderBean);
            carShopBean.get().getCarsItemsBeans().removeAll(carsItemsBeanList);
            cartShopRepository.saveAndFlush(carShopBean.get());
        }
        return new ResponseEntity<>(new ApiResponse(
                "Correct",HttpStatus.OK,"Order registrada"),HttpStatus.OK);
    }

    // UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(Long idOrden ,Long idEmployees){
        Optional<OrderBean>foundObject = repository.findById(idOrden);
        Optional<EmployeesBean>employeesBean = employeesRepository.findById(idEmployees);

        if (foundObject.isPresent() && employeesBean.isPresent()) {
            foundObject.get().setEmployeesBean(employeesBean.get());
            foundObject.get().setStatusBean(statusRepository.findById(2L).get());
            foundObject.get().setDateSending(LocalDate.now());
            repository.saveAndFlush(foundObject.get());
            return new ResponseEntity<>(new ApiResponse("", HttpStatus.OK, "Order actualizada"),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                "Order no encontrada"),HttpStatus.BAD_REQUEST);
    }
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> finish(Long idOrden ){
        Optional<OrderBean>foundObject = repository.findById(idOrden);
        MovementTypeBean movementTypeBean = movementTypeRepository.findById(3L).get();
        Set<MovementHistoryBean> movementHistoryBeans= new HashSet<MovementHistoryBean>();
        if (foundObject.isPresent()) {
            foundObject.get().getOrderItemBeans().forEach(orderItemBean -> {
                    MovementHistoryBean bean = new MovementHistoryBean();
                    bean.setQuantity((float) orderItemBean.getQuantity());
                    bean.setProductExtrasBean(orderItemBean.getProductExtrasBean());
                    bean.setPriceKgBean(foundObject.get().getPriceKgBean());
                    bean.setDate(LocalDateTime.now());
                    bean.setMovementTypeBean(movementTypeBean);
                    movementHistoryBeans.add(bean);


            });
            foundObject.get().setStatusBean(statusRepository.findById(1L).get());
            repository.saveAndFlush(foundObject.get());
            movementHistoryRepository.saveAllAndFlush(movementHistoryBeans);
            return new ResponseEntity<>(new ApiResponse("", HttpStatus.OK, "Order actualizada"),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true,
                "Order no encontrada"),HttpStatus.BAD_REQUEST);
    }
}
