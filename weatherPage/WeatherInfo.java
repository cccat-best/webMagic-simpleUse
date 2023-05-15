package org.example;

public class WeatherInfo {
    private String area;
    private String temperature;
    private String element;
    private String tourismindex;
    public WeatherInfo(){
    }
    public WeatherInfo(String area, String temperature, String element, String tourismindex) {
        this.area = area;
        this.temperature = temperature;
        this.element = element;
        this.tourismindex = tourismindex;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getTourismindex() {
        return tourismindex;
    }

    public void setTourismindex(String tourismindex) {
        this.tourismindex = tourismindex;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "area='" + area + '\'' +
                ", temperature='" + temperature + '\'' +
                ", element='" + element + '\'' +
                ", tourismindex='" + tourismindex + '\'' +
                '}';
    }
}
