package openWeatherAPITest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.http.HttpStatus;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

public class UnirestTest {

    @Test
    public void shouldFetchAllCitiesWeatherData() throws UnirestException {
        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("Berlin");

        for (String city : cities) {
            String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=55f42aa7100c6f035056aae2b29c54ae", city);
            HttpResponse<JsonNode> response = Unirest
                    .get(url)
                    .asJson();

            assertNotNull(response.getBody());
            assertEquals((int) HttpStatus.SC_OK, response.getStatus());
        }

    }

}
