package pl.grzegorz.snapshotstories.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/submitForm")
public class ContactController
{

    @GetMapping("/")
    public static String indexPageView(){
        return "contactPage";
    }


}
