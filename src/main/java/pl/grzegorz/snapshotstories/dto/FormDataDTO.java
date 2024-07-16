package pl.grzegorz.snapshotstories.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

public class FormDataDTO {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Instagram handle is required")
    private String instagram;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Text1 is required")
    private String text1;

    @NotEmpty(message = "Text2 is required")
    private String text2;

    // Getters and setters
}
