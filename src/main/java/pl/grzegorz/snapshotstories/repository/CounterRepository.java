package pl.grzegorz.snapshotstories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.grzegorz.snapshotstories.entity.Counter;

public interface CounterRepository extends JpaRepository<Counter, Long> {
}