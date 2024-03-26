package utez.edu.mx.IntegradoraPodec.Controller.DtoShare;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolsBean;

@Data
@Getter
@Setter
public class EmployeesPersonDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String sex;
    private String lastName;
    private String phone;
    private Long rols;
    private MultipartFile image;



    public EmployeesBean toEntity ()  {
        PersonBean personBean  = new PersonBean( name,  lastName,  phone , sex );
        RolsBean rolsBean  = new RolsBean(rols);
        System.out.println("Passowrd " + password);
        EmployeesBean employeesBean = new EmployeesBean(email, password);
        employeesBean.setPersonBean(personBean);
        employeesBean.setRolsBean(rolsBean);
        return  employeesBean;
    }
    public EmployeesBean toEntityId ()  {
        PersonBean personBean  = new PersonBean( name,  lastName,  phone , sex );
        RolsBean rolsBean  = new RolsBean(rols);
        EmployeesBean employeesBean = new EmployeesBean(id,email, password);
        System.out.println("Id employees " + employeesBean.getId());

        employeesBean.setPersonBean(personBean);
        employeesBean.setRolsBean(rolsBean);
        return  employeesBean;
    }
    public MultipartFile toFile(){
        return image;
    }
}
