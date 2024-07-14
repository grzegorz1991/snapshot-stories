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
                                             @RequestParam String email,

                                             @RequestParam String message) {

        FormData formData = new FormData();
        formData.setName(name);
        formData.setEmail(email);

        formData.setMessage(message);

        formService.saveFormData(formData);


        return ResponseEntity.ok("Form submitted successfully");
    }
}