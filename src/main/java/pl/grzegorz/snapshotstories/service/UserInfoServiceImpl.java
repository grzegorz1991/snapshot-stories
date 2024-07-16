package pl.grzegorz.snapshotstories.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import pl.grzegorz.snapshotstories.entity.UserInfo;
import pl.grzegorz.snapshotstories.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_FORWARDED");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    @Override
    public String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }

    @Override
    public String getOS(String userAgent) {
        // Logic to parse OS from user agent string
        // Example implementation:
        if (userAgent.toLowerCase().contains("windows")) {
            return "Windows";
        } else if (userAgent.toLowerCase().contains("macintosh")) {
            return "Macintosh";
        } else if (userAgent.toLowerCase().contains("linux")) {
            return "Linux";
        } else {
            return "Unknown";
        }
    }

    @Override
    public String getBrowser(String userAgent) {
        // Logic to parse browser from user agent string
        // Example implementation:
        if (userAgent.toLowerCase().contains("chrome")) {
            return "Chrome";
        } else if (userAgent.toLowerCase().contains("firefox")) {
            return "Firefox";
        } else if (userAgent.toLowerCase().contains("safari")) {
            return "Safari";
        } else if (userAgent.toLowerCase().contains("edge")) {
            return "Edge";
        } else if (userAgent.toLowerCase().contains("opera")) {
            return "Opera";
        } else {
            return "Unknown";
        }
    }



//
//    public String getClientIp(HttpServletRequest request) {
//        String ipAddress = request.getHeader("X-Forwarded-For");
//        if (ipAddress == null || ipAddress.isEmpty()) {
//            ipAddress = request.getRemoteAddr();
//        }
//        return ipAddress;
//    }
//
//    public String getUserAgent(HttpServletRequest request) {
//        return request.getHeader("User-Agent");
//    }
//
//    public String getOS(String userAgent) {
//        if (userAgent.toLowerCase().contains("windows")) {
//            return "Windows";
//        } else if (userAgent.toLowerCase().contains("mac")) {
//            return "Mac";
//        } else if (userAgent.toLowerCase().contains("x11")) {
//            return "Unix";
//        } else if (userAgent.toLowerCase().contains("android")) {
//            return "Android";
//        } else if (userAgent.toLowerCase().contains("iphone")) {
//            return "iPhone";
//        } else {
//            return "Unknown";
//        }
//    }
//
//    public String getBrowser(String userAgent) {
//        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
//            return "Internet Explorer";
//        } else if (userAgent.contains("Firefox")) {
//            return "Firefox";
//        } else if (userAgent.contains("Chrome")) {
//            return "Chrome";
//        } else if (userAgent.contains("Safari")) {
//            return "Safari";
//        } else if (userAgent.contains("Opera") || userAgent.contains("OPR")) {
//            return "Opera";
//        } else {
//            return "Unknown";
//        }
//    }
}
