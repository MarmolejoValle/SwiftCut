package utez.edu.mx.IntegradoraPodec.Model.Person;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import utez.edu.mx.IntegradoraPodec.Model.StatusPerson.StatusPersonBean;
import utez.edu.mx.IntegradoraPodec.Model.StatusPerson.StatusPersonDto;

import java.util.Objects;
@Data

public final class PersonDto {
    private final String name;
    private final String lastName;
    private final String phone;
    private final String urlPhoto;
    private final String sex;
    private final StatusPersonDto statusPersonDto;


    public PersonDto(String name, String lastName,  String urlPhoto ) {
        this.name = name;
        this.lastName = lastName;
        this.urlPhoto = urlPhoto;
        statusPersonDto = null;
        sex = null;
        phone = null;
    }

    public PersonDto(String name, String lastName, String type, String urlPhoto , String phone,String sex) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.sex = sex;
        this.urlPhoto = urlPhoto;
        this.statusPersonDto = new StatusPersonDto(type);
    }
    public PersonDto(String name, String lastName, String type, String urlPhoto , String phone) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.urlPhoto = urlPhoto;
        this.statusPersonDto = new StatusPersonDto(type);
        this.sex = null;
    }

}
