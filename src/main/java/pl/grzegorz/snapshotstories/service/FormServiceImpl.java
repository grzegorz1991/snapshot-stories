package pl.grzegorz.snapshotstories.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.snapshotstories.dto.FormDataDTO;
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

    @Override
    public void saveFormData(FormDataDTO formDataDTO) {
        FormData formData = new FormData();
        formData.setName(formDataDTO.getName());
        formData.setInstagram(formDataDTO.getInstagram());
        formData.setEmail(formDataDTO.getEmail());
        formData.setText1(formDataDTO.getText1());
        formData.setText2(formDataDTO.getText2());

        formDataRepository.save(formData);
    }
}