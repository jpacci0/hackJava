public class Car {
    private String model;
    private int year;
    private double price;
    private int telaio;

    public Car (String model, int year, double price, int telaio) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.telaio = telaio;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public double getPrice() {
        return this.price;
    }

    public int getTelaio() {
        return this.telaio;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTelaio(int telaio) {
        this.telaio = telaio;
    }

    public String print() {return "Model: " + this.model + " Year: " + this.year + " Price: " + this.price;}

}