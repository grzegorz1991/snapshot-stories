package pl.grzegorz.snapshotstories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzegorz.snapshotstories.entity.Counter;
import pl.grzegorz.snapshotstories.repository.CounterRepository;

@Service
public class CounterService {

    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Transactional
    public Long incrementCount() {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        counter.incrementCount();
        counterRepository.save(counter);
        return counter.getCount();
    }

    @Transactional(readOnly = true)
    public Long getCount() {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        return counter.getCount();
    }
}
