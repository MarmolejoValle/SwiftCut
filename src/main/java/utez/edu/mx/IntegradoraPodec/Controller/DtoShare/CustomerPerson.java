package utez.edu.mx.IntegradoraPodec.Controller.DtoShare;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;

@Data
@Getter
@Setter
public class CustomerPerson {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String phone;
    private String sex;
    private MultipartFile image;

    public CustomersBean toEntity ()  {
        PersonBean personBean  = new PersonBean( name,  lastName,  phone , sex );
        System.out.println("Passowrd " + password);
        CustomersBean customersBean = new CustomersBean(email, password);
        customersBean.setPersonBean(personBean);
        return customersBean;
    }
    public CustomersBean toEntityId ()  {
        PersonBean personBean  = new PersonBean( name,  lastName,  phone , sex );
        CustomersBean customersBean = new CustomersBean(id,email, password);
        System.out.println("Id employees " + customersBean.getId());

       customersBean.setPersonBean(personBean);
        return customersBean;
    }

    public MultipartFile toFile(){
        return image;
    }
}
