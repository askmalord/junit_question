package service.medical;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoFileRepository;
import ru.netology.patient.service.alert.SendAlertServiceImpl;
import ru.netology.patient.service.medical.MedicalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicalServiceImplTest {

    @Test
    public void checkBloodPressureWithMessageTest() {
        final PatientInfo patientInfo = new PatientInfo();
        final BloodPressure normalBloodPressure = new BloodPressure(60, 40);

        PatientInfoFileRepository patientInfoRepository = Mockito.mock(PatientInfoFileRepository.class);
        Mockito.when(patientInfoRepository
                .getById(Mockito.anyString()))
                .thenReturn(new PatientInfo("1","Иван", "Петров",
                        LocalDate.of(1980, 11, 26),
                        new HealthInfo(new BigDecimal("36.65"),
                                new BloodPressure(120, 80))));
        SendAlertServiceImpl alertService = Mockito.mock(SendAlertServiceImpl.class);
        Mockito.doCallRealMethod().when(alertService).send(Mockito.anyString());

        MedicalServiceImpl medicalService = new MedicalServiceImpl(patientInfoRepository, alertService);
        medicalService.checkBloodPressure(patientInfo.getId(), normalBloodPressure);

        Mockito.verify(alertService, Mockito.only()).send(Mockito.anyString());
    }

    @Test
    public void checkBloodPressureWithoutMessageTest() {
        final PatientInfo patientInfo = new PatientInfo();
        final BloodPressure normalBloodPressure = new BloodPressure(120, 80);

        PatientInfoFileRepository patientInfoRepository = Mockito.mock(PatientInfoFileRepository.class);
        Mockito.when(patientInfoRepository
                .getById(Mockito.anyString()))
                .thenReturn(new PatientInfo("1","Иван", "Петров",
                        LocalDate.of(1980, 11, 26),
                        new HealthInfo(new BigDecimal("36.65"),
                                new BloodPressure(120, 80))));
        SendAlertServiceImpl alertService = Mockito.mock(SendAlertServiceImpl.class);
        Mockito.doCallRealMethod().when(alertService).send(Mockito.anyString());

        MedicalServiceImpl medicalService = new MedicalServiceImpl(patientInfoRepository, alertService);
        medicalService.checkBloodPressure(patientInfo.getId(), normalBloodPressure);

        Mockito.verify(alertService, Mockito.never()).send(Mockito.anyString());
    }

    @Test
    public void checkTemperatureWithMessageTest() {
        final PatientInfo patientInfo = new PatientInfo();
        final BigDecimal normalTemperature = new BigDecimal("36.6");

        PatientInfoFileRepository patientInfoRepository = Mockito.mock(PatientInfoFileRepository.class);
        Mockito.when(patientInfoRepository
                .getById(Mockito.anyString()))
                .thenReturn(new PatientInfo("2","Артем", "Ильин",
                        LocalDate.of(1990, 4, 15),
                        new HealthInfo(new BigDecimal("38.65"),
                                new BloodPressure(110, 70))));
        SendAlertServiceImpl alertService = Mockito.mock(SendAlertServiceImpl.class);
        Mockito.doCallRealMethod().when(alertService).send(Mockito.anyString());

        MedicalServiceImpl medicalService = new MedicalServiceImpl(patientInfoRepository, alertService);
        medicalService.checkTemperature(patientInfo.getId(), normalTemperature);

        Mockito.verify(alertService, Mockito.only()).send(Mockito.anyString());
    }

    @Test
    public void checkTemperatureWithoutMessageTest() {
        final PatientInfo patientInfo = new PatientInfo();
        final BigDecimal normalTemperature = new BigDecimal("36.6");

        PatientInfoFileRepository patientInfoRepository = Mockito.mock(PatientInfoFileRepository.class);
        Mockito.when(patientInfoRepository
                .getById(Mockito.anyString()))
                .thenReturn(new PatientInfo("2","Артем", "Ильин",
                        LocalDate.of(1990, 4, 15),
                        new HealthInfo(new BigDecimal("36.65"),
                                new BloodPressure(110, 70))));
        SendAlertServiceImpl alertService = Mockito.mock(SendAlertServiceImpl.class);
        Mockito.doCallRealMethod().when(alertService).send(Mockito.anyString());

        MedicalServiceImpl medicalService = new MedicalServiceImpl(patientInfoRepository, alertService);
        medicalService.checkTemperature(patientInfo.getId(), normalTemperature);

        Mockito.verify(alertService, Mockito.never()).send(Mockito.anyString());
    }
}
