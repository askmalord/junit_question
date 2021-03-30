package i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LocalizationServiceImplTest {

    @Test
    public void localeRussianMessageTest() {
        final String expected = "Добро пожаловать";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.RUSSIA);
        assertThat(expected, equalTo(actual));
    }

    @Test
    public void localeUSAMessageTest() {
        final String expected = "Welcome";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.USA);
        assertThat(expected, equalTo(actual));
    }

    @Test
    public void localeGermanyMessageTest() {
        final String expected = "Welcome";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.GERMANY);
        assertThat(expected, equalTo(actual));
    }

    @Test
    public void localeBrazilMessageTest() {
        final String expected = "Welcome";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.BRAZIL);
        assertThat(expected, equalTo(actual));
    }
}
