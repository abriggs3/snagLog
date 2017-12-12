package edu.matc.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.io.weatherbit.Data;
import edu.matc.io.weatherbit.DataItem;
import org.apache.log4j.Logger;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class WeatherApi {

    public DataItem callWeatherApi(Double latitude, Double longitude) {
        final Logger logger = Logger.getLogger(this.getClass());
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.weatherbit.io/v2.0/current?lat=" + latitude + "&lon=" + longitude + "&key=1d34655154764c77a72ac9c024dd1643");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Data data = null;
        try {
            data = mapper.readValue(response, Data.class);
            DataItem dataItem = data.getData().get(0);
            return dataItem;
        } catch (IOException e) {
            logger.error("failed to gather weather data from API, insert will be done with null values",e);
        }
        return null;
    }
}
