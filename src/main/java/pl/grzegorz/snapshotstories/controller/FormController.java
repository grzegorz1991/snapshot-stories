package pl.grzegorz.snapshotstories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import pl.grzegorz.snapshotstories.dto.FormDataDTO;
import pl.grzegorz.snapshotstories.entity.UserInfo;
import pl.grzegorz.snapshotstories.service.FormService;
import pl.grzegorz.snapshotstories.service.UserInfoService;

@Controller
@SessionAttributes("number")
public class FormController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private FormService formService;

    @PostMapping("/submitForm")
    public ResponseEntity<String> submitForm(
            @Validated @RequestBody FormDataDTO formDataDTO,
            HttpServletRequest request,
            Model model) {

        HttpSession session = request.getSession();
        Integer number = (Integer) session.getAttribute("number");

        if (number == null) {
            return ResponseEntity.status(400).body("Number is not set in the session");
        }

        try {
            // Retrieve user information
            UserInfo userInfo = new UserInfo();
            String ipAddress = userInfoService.getClientIp(request);
            if (ipAddress == null) {
                return ResponseEntity.status(400).body("Client IP Address is null");
            }
            userInfo.setIpAddress(ipAddress);

            String userAgent = userInfoService.getUserAgent(request);
            if (userAgent == null) {
                return ResponseEntity.status(400).body("User-Agent is null");
            }
            userInfo.setUserAgent(userAgent);

            String os = userInfoService.getOS(userAgent);
            if (os == null) {
                return ResponseEntity.status(400).body("OS information is null");
            }
            userInfo.setOs(os);

            String browser = userInfoService.getBrowser(userAgent);
            if (browser == null) {
                return ResponseEntity.status(400).body("Browser information is null");
            }
            userInfo.setBrowser(browser);

            // Save user information
            userInfoService.saveUserInfo(userInfo);

            // Save form data along with user information
            formService.saveFormData(formDataDTO, userInfo, number);

            return ResponseEntity.ok("Form submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while processing your request: " + e.getMessage());
        }
    }
}
