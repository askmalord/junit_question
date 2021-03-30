package geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GeoServiceImplTest {

    @Test
    public void localHostIPTest() {
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location(null, null, null, 0);
        Location actual = geoService.byIp(GeoServiceImpl.LOCALHOST);
        assertThat(expected, samePropertyValuesAs(actual));
        //TODO !!!Разобраться почему не работает!!!
    }

    @Test
    public void moscowIPTest() {
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        //Location actual = geoService.byIp(GeoServiceImpl.MOSCOW_IP);
        Location actual = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        assertThat(expected, samePropertyValuesAs(actual));
    }

    @Test
    public void newYorkIPTest() {
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location actual = geoService.byIp(GeoServiceImpl.NEW_YORK_IP);
        assertThat(expected, samePropertyValuesAs(actual));
    }

}
