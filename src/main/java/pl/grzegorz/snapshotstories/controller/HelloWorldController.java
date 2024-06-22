package pl.grzegorz.snapshotstories.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello Message");
        return "hello";
    }
}
