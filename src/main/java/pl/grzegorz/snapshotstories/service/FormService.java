package pl.grzegorz.snapshotstories.service;


import pl.grzegorz.snapshotstories.dto.FormDataDTO;
import pl.grzegorz.snapshotstories.entity.FormData;

public interface FormService {
    void saveFormData(FormData formData);
    void saveFormData(FormDataDTO formDataDTO);
}