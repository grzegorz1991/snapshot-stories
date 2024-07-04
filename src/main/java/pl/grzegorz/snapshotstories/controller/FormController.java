package pl.grzegorz.snapshotstories.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/submitForm")
public class FormController {
//
//    @GetMapping
//    public String showForm() {
//        // Show the HTML form
//        return "contactForm"; // Assuming "contactForm.html" is your HTML file name
//    }

    @PostMapping
    public String submitForm(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String phone,
                             @RequestParam String message) {
        // Here you can process the form data, e.g., save to a database, send an email, etc.
        // For simplicity, we'll just print the data to console
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Message: " + message);

        // You can redirect to a success page or return a success message
        return "redirect:/success"; // Redirect to a success page
    }


}
