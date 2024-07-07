package pl.grzegorz.snapshotstories.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.snapshotstories.entity.FormData;
import pl.grzegorz.snapshotstories.repository.FormDataRepository;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormDataRepository formDataRepository;

    @Override
    public void saveFormData(FormData formData) {
        formDataRepository.save(formData);
    }
}