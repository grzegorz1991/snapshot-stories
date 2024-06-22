package pl.grzegorz.snapshotstories.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/index")
    public static String indexPageView(){

        return "index";
    }
}
