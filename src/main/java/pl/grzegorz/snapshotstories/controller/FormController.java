package pl.grzegorz.snapshotstories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.grzegorz.snapshotstories.entity.FormData;
import pl.grzegorz.snapshotstories.service.FormService;

@Controller
@RequestMapping("/submitForm")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping
    public ResponseEntity<String> submitForm(@RequestParam String name,
                                             @RequestParam String instagram,
                                             @RequestParam String email,
                                             @RequestParam String text1,
                                             @RequestParam String text2) {

        if (name.isEmpty() || instagram.isEmpty() || email.isEmpty() || text1.isEmpty() || text2.isEmpty()) {
            return ResponseEntity.badRequest().body("All fields are required");
        }

        FormData formData = new FormData();
        formData.setName(name);
        formData.setInstagram(instagram);
        formData.setEmail(email);
        formData.setText1(text1);
        formData.setText2(text2);

        formService.saveFormData(formData);

        return ResponseEntity.ok("Form submitted successfully");
    }
}