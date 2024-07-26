package pl.grzegorz.snapshotstories.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class IndexController {

    @GetMapping("/")
    public static String indexPageView(Model model){
        int number = 0; // 0 indicates that user entered URL without specifing what camera he obtained;
        model.addAttribute("number", number);
        System.out.println(0);


        return "index";
    }

    @GetMapping("/{number}")
    public String indexPageViewWithCameraNumber(@PathVariable("number") int number, Model model) {
        model.addAttribute("number", number);
        System.out.println(number);

        return "index";
    }
    @GetMapping("/success")
    public String showSuccessView() {
        return "success";
    }


}
