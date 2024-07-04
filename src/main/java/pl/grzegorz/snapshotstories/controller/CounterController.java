package pl.grzegorz.snapshotstories.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.grzegorz.snapshotstories.service.CounterService;

@Controller
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/count")
    public String showHomePage(Model model) {
        Long count = counterService.incrementCount();
        model.addAttribute("accessCount", count);
        return "hello"; // Assuming "index.html" exists in templates folder
    }
}
