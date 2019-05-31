import java.util.Random;
import sensor.PressureSensor;
public class PressureSensorAdapter implements SensorInterface{
    private PressureSensor adaptee;
    private double pressure;

    public PressureSensorAdapter(){

    }
    @Override
    public double readValue(){
        Random r = new Random();
        int value = r.nextInt(10);
        this.pressure = (double)value;
        return this.pressure;
    }
    @Override
    public String getReport(){
        String report;
        if(this.pressure>6.58){
            report="DANGER -->"+this.pressure;
            return report;
        }
        if(this.pressure<5){
            report="OK -->"+this.pressure;
            return report;
        }
        else{
            report="CRITICAL -->"+this.pressure;
            return report;
        }
    }
    @Override
    public String getSensorName(){
        return "Pressure Sensor";
    }
}
