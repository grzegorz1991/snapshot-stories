package pl.grzegorz.snapshotstories.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public static String indexPageView(){

        return "index";
    }

    @GetMapping("/success")
    public String showSuccessView() {

        return "success";
    }
}
