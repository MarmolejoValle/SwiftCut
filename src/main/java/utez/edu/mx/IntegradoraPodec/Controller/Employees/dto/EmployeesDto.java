package utez.edu.mx.IntegradoraPodec.Controller.Employees.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;

@Data
@Getter
@Setter
public class EmployeesDto {
    private Long id;
    private String email;
    private String password;

    public EmployeesBean toEntity(){
        return new EmployeesBean(email, password);
    }

    public EmployeesBean toEntityId(){
        return new EmployeesBean(id, email, password) ;
    }
}

