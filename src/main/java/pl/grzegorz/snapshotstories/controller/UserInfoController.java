package pl.grzegorz.snapshotstories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grzegorz.snapshotstories.entity.UserInfo;
import pl.grzegorz.snapshotstories.service.UserInfoService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public UserInfo getUserInfo(HttpServletRequest request) {
        UserInfo userInfo = new UserInfo();
        String userAgent = userInfoService.getUserAgent(request);

        userInfo.setIpAddress(userInfoService.getClientIp(request));
        userInfo.setUserAgent(userAgent);
        userInfo.setOs(userInfoService.getOS(userAgent));
        userInfo.setBrowser(userInfoService.getBrowser(userAgent));
        System.out.println(userInfo);
        userInfoService.saveUserInfo(userInfo);
        return userInfo;
    }
}
