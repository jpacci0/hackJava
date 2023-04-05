public class App {
    public static void main(String[] args) throws Exception {
        //! vogliamo creare un programma che, dati dei sensori, prenda la temperatura esterna da ognuno di essi e ritorni la temperatura
        //! creiamo una lista di sensori che inizializziamo

        Sensor[] sensors = new Sensor[] {
            new Sensor(37, 55),
            new Sensor(28, 55),
            new Sensor(44, 55),
            new Sensor(25, 55),
        };

        
        System.out.println("La temp esterna media è di " + averageExtTemp(sensors) + " gradi");
    }

    public static double averageExtTemp(Sensor[] sensors){
        double sum = 0;
        for(Sensor sensor : sensors){
            sum += sensor.getExtTemp();
        }
        return (sum / sensors.length);
    }
}
