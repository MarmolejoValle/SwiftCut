package utez.edu.mx.IntegradoraPodec.Config;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;

@Controller
public class GreetingController {

    @MessageMapping("/greeting")
    public String handle(String greeting) {
        return "[" + LocalTime.now() + ": " + greeting;
    }
}
