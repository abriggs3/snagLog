package edu.matc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.io.weatherbit.Data;
import edu.matc.io.weatherbit.DataItem;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.Assert.*;


public class WeatherApiTest {
/* turned off to avoid over calling the API service
@Test
    public void  weatherApiTest() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.weatherbit.io/v2.0/current?lat=43.0747&lon=-89.3844&key=1d34655154764c77a72ac9c024dd1643");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Data data = mapper.readValue(response, Data.class);
        DataItem dataItem = data.getData().get(0);
        String city = dataItem.getCityName();

        assertEquals("Madison", city);
    }
*/
}

