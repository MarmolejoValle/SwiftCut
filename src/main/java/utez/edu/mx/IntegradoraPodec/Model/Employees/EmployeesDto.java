package utez.edu.mx.IntegradoraPodec.Model.Employees;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonDto;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolDto;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public final class EmployeesDto {


    private final long id;
    private final String email;
    private final Long count;
    private final String token ;
    private PersonDto personDto;
    private RolDto rolDto;

    public EmployeesDto(Long id , String  email , String token ) {
        this.count = 0L;
        this.email = email;
        this.id = id;
        this.token = token;
    }

    public EmployeesDto(Long count) {
        this.count = count;
        email = null;
        id = 0;
        token = null;
    }

    public EmployeesDto(Long id , String name, String email, String lastname,Long count) {
        this.count = count;
        this.email = email;
        this.id = id;
        this.personDto = new PersonDto(name , lastname);

        token = null;
    }
    public EmployeesDto(Long id , String name, String email, String lastname,int count) {
        this.count = (long) count;
        this.email = email;
        this.id = id;
        this.personDto = new PersonDto(name , lastname);

        token = null;
    }

    public EmployeesDto(Long id , String name, String email, String lastname, String type, String urlPhoto , String phone, String status) {
        this.id = id;
        this.email = email;
        this.personDto = new PersonDto(name,lastname, status,urlPhoto,phone);
        this.rolDto = new RolDto(type);
        this.count = null;
        token = null;
    }

    public EmployeesDto(Long id , String name, String lastname, String type, String urlPhoto ) {
        this.id = id;
        this.personDto = new PersonDto(name,lastname,urlPhoto);
        this.rolDto = new RolDto(type);
        this.count = null;
        email = null;
        token = null;
    }

    public EmployeesDto(Long id , String name,  String email,String lastname,String type, String urlPhoto , String phone, String status,String sex) {
        this.id = id;
        this.email = email;
        this.personDto = new PersonDto(name,lastname, status,urlPhoto,phone,sex);
        this.rolDto = new RolDto(type);
        this.count = null;
        token = null;
    }

    public long id() {
        return id;
    }



}