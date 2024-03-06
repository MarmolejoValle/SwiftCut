package utez.edu.mx.IntegradoraPodec.Config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiResponse {
    private Object data;
    private HttpStatus status;
    private Boolean error;
    private String mensaje;

    public ApiResponse(Object data, HttpStatus status, String mensaje) {
        this.data = data;
        this.status = status;
        this.mensaje = mensaje;

    }
    public ApiResponse(Object data, Boolean error, String mensaje) {
        this.data = data;
        this.error = error;
        this.mensaje = mensaje;
    }
}
