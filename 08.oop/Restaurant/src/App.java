public class App {
    public static void main(String[] args) throws Exception {

        Dish[] dishes = new Dish[2];
        dishes[0] = new Dish("Carbonara", 10, "Spaghetti, uova, guanciale, pecorino");
        dishes[1] = new Dish("Pasta pasticciata", 7, "Pasta, cotto, mozzarella, ragù");

        Drink[] drinks = new Drink[2];
        drinks[0] = new Drink("Coca cola", 3);
        drinks[1] = new Drink("Gin Tonic", 10);

        Restaurant restaurant = new Restaurant("Il ristorante di Jacopo", dishes, drinks);

        restaurant.stampaMenu();
    }
}
