package pl.grzegorz.snapshotstories.service;


import pl.grzegorz.snapshotstories.dto.FormDataDTO;
import pl.grzegorz.snapshotstories.entity.FormData;
import pl.grzegorz.snapshotstories.entity.UserInfo;

public interface FormService {
  //  void saveFormData(FormData formData);
  //  void saveFormData(FormDataDTO formDataDTO);

    void saveFormData(FormDataDTO formDataDTO, UserInfo userInfo, int cameraID);
}