public class Sensor {
    private int extTemp;
    
    public Sensor(int extTemp, int intTemp) {
        this.extTemp = extTemp;
        this.intTemp = intTemp;
    }
    private int intTemp;

    public int getIntTemp() {
        return intTemp;
    }
    public void setIntTemp(int intTemp) {
        this.intTemp = intTemp;
    }

    public int getExtTemp() {
        return extTemp;
    }
    public void setExtTemp(int extTemp) {
        this.extTemp = extTemp;
    }
}
