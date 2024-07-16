package pl.grzegorz.snapshotstories.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

import pl.grzegorz.snapshotstories.dto.FormDataDTO;
import pl.grzegorz.snapshotstories.entity.UserInfo;
import pl.grzegorz.snapshotstories.service.FormService;
import pl.grzegorz.snapshotstories.service.UserInfoService;

@Controller
@RequestMapping("/submitForm")
public class FormController {

    @Autowired
    private FormService formService;
    @Autowired
    private UserInfoService userInfoService;
//    @PostMapping
//    public ResponseEntity<String> submitForm(
//            @Valid @RequestBody FormDataDTO formDataDTO,
//            HttpServletRequest request) {
//
//        try {
//            // Retrieve user information
//            UserInfo userInfo = new UserInfo();
//            userInfo.setIpAddress(userInfoService.getClientIp(request));
//            userInfo.setUserAgent(userInfoService.getUserAgent(request));
//            userInfo.setOs(userInfoService.getOS(userInfo.getUserAgent()));
//            userInfo.setBrowser(userInfoService.getBrowser(userInfo.getUserAgent()));
//
//            // Save user information
//            userInfoService.saveUserInfo(userInfo);
//
//            // Save form data along with user information
//            formService.saveFormData(formDataDTO, userInfo);
//
//            return ResponseEntity.ok("Form submitted successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("An error occurred while processing your request: " + e.getMessage());
//        }
//
//    }

    @PostMapping()
    public ResponseEntity<String> submitForm(
            @Valid @RequestBody FormDataDTO formDataDTO,
            HttpServletRequest request) {

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
            formService.saveFormData(formDataDTO, userInfo);

            return ResponseEntity.ok("Form submitted successfully1");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while processing your request: " + e.getMessage());
        }
    }

}
