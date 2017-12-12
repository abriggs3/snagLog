package edu.matc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.io.weatherbit.Data;
import edu.matc.io.weatherbit.DataItem;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

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

    @Test
    public void  testTest() throws Exception {
        Double latitude = 45.972152;
        Double longitude = -89.327087;
        String latitudeString = Double.toString(latitude);
        String longitudeString = Double.toString(longitude);
        String url = "https://api.weatherbit.io/v2.0/current?lat=" + latitudeString + "&lon=" + longitudeString + "&key=1d34655154764c77a72ac9c024dd1643";

        Client client = ClientBuilder.newClient();
        //WebTarget target = client.target("https://api.weatherbit.io/v2.0/current?lat=" + latitude + "&lon=" + longitude + "&key=1d34655154764c77a72ac9c024dd1643");
        WebTarget target =
                client.target(url);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Data data = null;

        data = mapper.readValue(response, Data.class);
        DataItem dataItem = data.getData().get(0);


        assertEquals("???", dataItem);

    }

    */
}

