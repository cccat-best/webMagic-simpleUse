package org.example;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.sql.SQLException;
import java.util.Map;

public class WeatherPipeline implements Pipeline {
    WeatherJDBC jdbc = new WeatherJDBC();
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String,Object> all = resultItems.getAll();
        WeatherInfo weatherInfo = new WeatherInfo();
        for (String s : all.keySet()){
            weatherInfo = (WeatherInfo)all.get(s);
            try{
                jdbc.save(weatherInfo);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
