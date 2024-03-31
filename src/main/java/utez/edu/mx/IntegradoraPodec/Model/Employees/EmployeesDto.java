package utez.edu.mx.IntegradoraPodec.Model.Employees;

import lombok.Data;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonBean;
import utez.edu.mx.IntegradoraPodec.Model.Person.PersonDto;
import utez.edu.mx.IntegradoraPodec.Model.Rols.RolDto;

@Data
public final class EmployeesDto {


    private final long id;
    private final String email;
    private final Long count;

    private PersonDto personDto;
    private RolDto rolDto;

    public EmployeesDto(Long count) {
        this.count = count;
        email = null;
        id = 0;
    }

    public EmployeesDto(Long id , String name, String email, String lastname,Long count) {
        this.count = count;
        this.email = email;
        this.id = id;
        this.personDto = new PersonDto(name , lastname);

    }
    public EmployeesDto(Long id , String name, String email, String lastname,int count) {
        this.count = (long) count;
        this.email = email;
        this.id = id;
        this.personDto = new PersonDto(name , lastname);

    }

    public EmployeesDto(Long id , String name, String email, String lastname, String type, String urlPhoto , String phone, String status) {
        this.id = id;
        this.email = email;
        this.personDto = new PersonDto(name,lastname, status,urlPhoto,phone);
        this.rolDto = new RolDto(type);
        this.count = null;
    }

    public EmployeesDto(Long id , String name, String lastname, String type, String urlPhoto ) {
        this.id = id;
        this.personDto = new PersonDto(name,lastname,urlPhoto);
        this.rolDto = new RolDto(type);
        this.count = null;
        email = null;
    }

    public EmployeesDto(Long id , String name,  String email,String lastname,String type, String urlPhoto , String phone, String status,String sex) {
        this.id = id;
        this.email = email;
        this.personDto = new PersonDto(name,lastname, status,urlPhoto,phone,sex);
        this.rolDto = new RolDto(type);
        this.count = null;
    }

    public long id() {
        return id;
    }



}