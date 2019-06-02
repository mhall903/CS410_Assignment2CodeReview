
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class SensorApplication extends JFrame {
    public SensorApplication(String name, double value, String report) {
        JFrame f = new JFrame("Sensor Tracker");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = f.getContentPane();
        JProgressBar progressBar = new JProgressBar();
        TextArea tdisplay=new TextArea(1,15);
        tdisplay.append(report);

        if(name.contains("Temperature")){
            progressBar.setMaximum(400);

        }
        else if(name.contains("Pressure")){
            progressBar.setMaximum(10);

        }
        else {
            progressBar.setMaximum(5);

        }
        progressBar.setValue((int)value);
        progressBar.setStringPainted(true);

        if(report.contains("DANGER")){
            progressBar.setForeground(Color.RED);
        }
        else if(report.contains("OK")){
            progressBar.setForeground(Color.green);
        }
        else {
            progressBar.setForeground(Color.yellow);
        }
        Border border = BorderFactory.createTitledBorder(name);
        progressBar.setBorder(border);
        content.add(progressBar, BorderLayout.NORTH);
        content.add(tdisplay, BorderLayout.CENTER);
        f.setSize(600, 600);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        TemperatureSensorAdapter temp=new TemperatureSensorAdapter();
        RadiationSensorAdapter rad=new RadiationSensorAdapter();
        PressureSensorAdapter press=new PressureSensorAdapter();
        String tname=temp.getSensorName();
        String rname=rad.getSensorName();
        String pname=press.getSensorName();
        double tvalue=temp.readValue();
        double rvalue=rad.readValue();
        double pvalue=press.readValue();
        String tReport=temp.getReport();
        String rReport=rad.getReport();
        String pReport=press.getReport();

        SensorApplication appTemp = new SensorApplication(tname, tvalue, tReport);
        SensorApplication appPres = new SensorApplication(pname, pvalue, pReport);
        SensorApplication appRad = new SensorApplication(rname, rvalue, rReport);


    }
}






