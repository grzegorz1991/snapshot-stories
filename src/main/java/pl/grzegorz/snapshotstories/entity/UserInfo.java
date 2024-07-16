package pl.grzegorz.snapshotstories.entity;


import lombok.Data;

import jakarta.persistence.*;


@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private String userAgent;
    private String os;
    private String browser;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private FormData formData;
}
