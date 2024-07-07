package pl.grzegorz.snapshotstories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.grzegorz.snapshotstories.entity.FormData;

public interface FormDataRepository extends JpaRepository<FormData, Long> {
}