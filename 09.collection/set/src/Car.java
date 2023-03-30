public class Car {
    private String model;
    private int year;
    private double price;

    public Car (String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
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

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String print() {return "Model: " + this.model + " Year: " + this.year + " Price: " + this.price;}

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Car){
            Car other = (Car) obj;
            return model == other.model && year == other.year && price == other.price;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (model + year + price).hashCode();
    }
}