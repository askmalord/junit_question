package service.medical;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoFileRepository;
import ru.netology.patient.service.alert.SendAlertService;
import ru.netology.patient.service.alert.SendAlertServiceImpl;
import ru.netology.patient.service.medical.MedicalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicalServiceImplTest {

    @Test
    public void checkBloodPressureTest() {
        final PatientInfo patientInfo = new PatientInfo();
        final BloodPressure normalBloodPressure = new BloodPressure(60, 40);

        PatientInfoFileRepository patientInfoRepository = Mockito.mock(PatientInfoFileRepository.class);

//        Mockito.when(patientInfoRepository
//                .getById(Mockito.anyString()))
//                .thenReturn(new PatientInfo());
//        PatientInfo info = Mockito.mock(PatientInfo.class);
//        Mockito.when(info.getHealthInfo().getBloodPressure()).thenReturn(new BloodPressure(100, 100));
        Mockito.when(patientInfoRepository
                .getById(Mockito.anyString())
                .getHealthInfo()
                .getBloodPressure())
                .thenReturn(new BloodPressure(100, 100));

        SendAlertServiceImpl alertService = Mockito.mock(SendAlertServiceImpl.class);

        Mockito.verify(alertService, Mockito.only()).send(Mockito.anyString());

        MedicalServiceImpl medicalService = new MedicalServiceImpl(patientInfoRepository, alertService);

        medicalService.checkBloodPressure(patientInfo.getId(), normalBloodPressure);
    }
}
