package za.co.wyzetech.smartprocesses.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/ui")
public class SmartProcessesController {

    @GetMapping("/")
    public ModelAndView ping(ModelAndView model) {
	model.setViewName("index.html");
        return model;
    }
}
