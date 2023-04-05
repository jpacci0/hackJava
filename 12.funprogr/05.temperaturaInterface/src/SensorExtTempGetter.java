
public class SensorExtTempGetter implements PropertyGetter {
    public double getDoubleProperty(Object obj){
        Sensor s = (Sensor) obj;
        return s.getExtTemp();
    }
}
