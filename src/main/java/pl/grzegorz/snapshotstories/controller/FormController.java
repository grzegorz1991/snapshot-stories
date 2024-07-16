package pl.grzegorz.snapshotstories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

import pl.grzegorz.snapshotstories.dto.FormDataDTO;
import pl.grzegorz.snapshotstories.service.FormService;

@Controller
@RequestMapping("/submitForm")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping
    public ResponseEntity<String> submitForm(
            @Valid @RequestParam("name") String name,
            @Valid @RequestParam("instagram") String instagram,
            @Valid @RequestParam("email") String email,
            @Valid @RequestParam("text1") String text1,
            @Valid @RequestParam("text2") String text2) {

        try {
            FormDataDTO formDataDTO = new FormDataDTO();
            formDataDTO.setName(name);
            formDataDTO.setInstagram(instagram);
            formDataDTO.setEmail(email);
            formDataDTO.setText1(text1);
            formDataDTO.setText2(text2);

            formService.saveFormData(formDataDTO);

            return ResponseEntity.ok("Form submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while processing your request: " + e.getMessage());
        }
    }
}
