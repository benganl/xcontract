package za.co.wyzetech.smartprocesses.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ui")
public class SmartProcessesController {

    @GetMapping("/ping")
    public String ping() {
        return "Hello, from Controller...";
    }
}
