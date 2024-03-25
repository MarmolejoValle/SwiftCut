package utez.edu.mx.IntegradoraPodec.Controller.Person.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;

@Data
@Getter
@Setter
public class PersonDto {
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private MultipartFile file;
    private String type;




    public PersonBean toEntity(){
        return new PersonBean(name, lastName, phone);
    }

    public PersonBean toEntityId(){
        return new PersonBean(id, name, lastName, phone) ;
    }


    public MultipartFile toFile(){
        return file;
    }
}
