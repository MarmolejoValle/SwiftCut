package utez.edu.mx.IntegradoraPodec.Controller.Socket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ChatDto {
    private String nickname;
    private String content;
    private Date tieDate;
}
