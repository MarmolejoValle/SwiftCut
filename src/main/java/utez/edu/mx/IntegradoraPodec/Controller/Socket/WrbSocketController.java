package utez.edu.mx.IntegradoraPodec.Controller.Socket;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;

import java.util.Date;


@Controller

public class WrbSocketController {


        @SendTo("/topic/messages")
    public String sendMessage(@Payload ChatDto chatDto)
    {
        chatDto.setTieDate(new Date());
        return "chatDto";
    }

}
