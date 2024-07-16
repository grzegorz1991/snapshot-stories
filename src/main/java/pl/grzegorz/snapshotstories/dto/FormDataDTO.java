package pl.grzegorz.snapshotstories.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
