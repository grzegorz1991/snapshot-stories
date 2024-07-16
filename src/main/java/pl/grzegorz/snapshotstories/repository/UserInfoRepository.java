package pl.grzegorz.snapshotstories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.grzegorz.snapshotstories.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}