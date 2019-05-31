import java.util.Random;
import sensor.RadiationSensor;
public class RadiationSensorAdapter implements SensorInterface {
    private RadiationSensor adaptee;
    private double radiation;

    public RadiationSensorAdapter(){

    }
    @Override
    public double readValue(){
        Random r = new Random();
        int value = r.nextInt(5);
        this.radiation = (double)value;
        return this.radiation;
    }
    @Override
    public String getReport(){
        String report;
        if(this.radiation>4){
            report="DANGER -->"+this.radiation;
            return report;
        }
        if(this.radiation<3){
            report="OK -->"+this.radiation;
            return report;
        }
        else{
            report="CRITICAL -->"+this.radiation;
            return report;
        }
    }
    @Override
    public String getSensorName(){
        return "Radiation Sensor";
    }

}
