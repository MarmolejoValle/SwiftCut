package utez.edu.mx.IntegradoraPodec.Services.Employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Firebase.FirebaseInitializer;
import utez.edu.mx.IntegradoraPodec.Model.Cart_Shop.CarShopBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesRepository;
import utez.edu.mx.IntegradoraPodec.Model.Order.OrdenDto;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Product.ProductBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsRepository;
import utez.edu.mx.IntegradoraPodec.Model.StatusPerson.StatusPersonBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Data
public class EmployeesService {
    private final EmployeesRepository repository;
    private FirebaseInitializer firebaseInitializer;
    private final RolsRepository rolsRepository;


    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getEmployeeId(Long id){
        Optional<EmployeesDto> employee = repository.getEmployeeId(id);
        return new ResponseEntity<>(new ApiResponse(employee, HttpStatus.OK, "Empleados encontrados"), HttpStatus.OK);

    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getEmployeeEmail(String email){
        Optional<EmployeesDto> employee = repository.findByInfo(email);
        return new ResponseEntity<>(new ApiResponse(employee, HttpStatus.OK, "Empleados encontrados"), HttpStatus.OK);

    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getCountOrdens(Long id) {
        Optional<EmployeesDto> countDate = repository.getCountOrdens(id);
        return new ResponseEntity<>(new ApiResponse(countDate, HttpStatus.OK, "Empleados encontrados"), HttpStatus.OK);

    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getOrdens(Long id) {
        List<OrdenDto> Ordens = repository.findByOrderBeansOrderById(id);
        return new ResponseEntity<>(new ApiResponse(Ordens, HttpStatus.OK, "Empleados encontrados"), HttpStatus.OK);

    }


    //Leer (Consulta individual)
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        Optional<EmployeesBean> object = repository.findById(id);
        if (object.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(object.get(), HttpStatus.OK, "Eampleado encontrado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, false, "Empleado no encontrada"), HttpStatus.NOT_FOUND);
        }
    }
    //eliminar
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        Optional<EmployeesBean> opt = repository.findById(id);
        if (opt.isPresent()){
            repository.deleteById(id);
            return  new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Empleado eliminado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "No se encontro el empleado"), HttpStatus.NOT_FOUND);
    }

    //SELECT * FROM
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAllEmployeesDto(), HttpStatus.OK,"Empleado encontrado"), HttpStatus.OK);
    }

    // CREATE
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>save(EmployeesBean object, MultipartFile file){
        StatusPersonBean statusPersonBean = new StatusPersonBean();
        statusPersonBean.setId(2L);
        object.getPersonBean().setStatusPersonBean(statusPersonBean);

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPsw = bcrypt.encode(object.getPassword());
        object.setPassword(encryptedPsw);

        EmployeesBean optional  = repository.saveAndFlush(object) ;
        if (optional.getEmail() != null){
            object.getPersonBean().setUrlPhoto(firebaseInitializer.upload(file));
            return new ResponseEntity<>(new ApiResponse(optional
                    ,HttpStatus.OK,"Persona registrada"),HttpStatus.OK);
        }


       // repository.saveAndFlush(object)
        return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(object)
               ,HttpStatus.OK,"Empleado creado"),HttpStatus.OK);
    }

    // UPDATE

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse>update(EmployeesBean object, MultipartFile file){
        Optional<EmployeesBean>foundObject = repository.findById(object.getId());
        if (!foundObject.isPresent())
            return new ResponseEntity<>(new ApiResponse((HttpStatus.BAD_REQUEST), true, "Empleado no encontrado"),HttpStatus.BAD_REQUEST);



       foundObject.get().getPersonBean().setName(object.getPersonBean().getName());
         foundObject.get().getPersonBean().setPhone(object.getPersonBean().getPhone());
        foundObject.get().getPersonBean().setSex(object.getPersonBean().getSex());
        foundObject.get().setEmail(object.getEmail());
         foundObject.get().getPersonBean().setLastName(object.getPersonBean().getLastName());
        if (object.getRolsBean().getId() != null )  {
            System.out.println("Id " + object.getRolsBean().getId());
            Optional<RolsBean> rolsBean = rolsRepository.findById(object.getRolsBean().getId());
            foundObject.get().setRolsBean(rolsBean.get());
        }



        if (object.getPassword() !=null){
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptedPsw = bcrypt.encode(object.getPassword());
            foundObject.get().setPassword(encryptedPsw);
        }


        if (file != null)
            foundObject.get().getPersonBean().setUrlPhoto(firebaseInitializer.upload(file));


        repository.saveAndFlush(foundObject.get());
        // repository.saveAndFlush(object)
        return new ResponseEntity<>(new ApiResponse(""
                ,HttpStatus.OK,"Empleado Actualizado"),HttpStatus.OK);
    }



}
