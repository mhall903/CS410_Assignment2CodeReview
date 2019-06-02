import sensor.TemperatureSensor;
import java.util.Random;

public class TemperatureSensorAdapter implements SensorInterface {
    private TemperatureSensor adaptee;
    private double temperature;

    public TemperatureSensorAdapter(){

    }
    @Override
    public double readValue(){
        Random r = new Random();
        int value = r.nextInt(400);
        this.temperature = (double)value;
        return this.temperature;
    }
    @Override
    public String getReport(){
        String report;
        if(this.temperature>300){
            report="DANGER -->"+this.temperature;
            return report;
     }
        if(this.temperature<235){
            report="OK -->"+this.temperature;
            return report;
        }
        else{
            report="CRITICAL -->"+this.temperature;
            return report;
        }
    }
    @Override
    public String getSensorName(){
        return "Temperature Sensor";
    }


}
