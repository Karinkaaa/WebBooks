package app.groovy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/1")
    String home() {
        return "Hello world!";
    }
}
