package pl.grzegorz.snapshotstories.service;



import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import pl.grzegorz.snapshotstories.entity.UserInfo;

@Service
public interface UserInfoService {
    void saveUserInfo(UserInfo userInfo);

    String getClientIp(HttpServletRequest request);
    String getUserAgent(HttpServletRequest request);
    String getOS(String userAgent);
    String getBrowser(String userAgent);
}