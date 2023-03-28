public class Restaurant {
    private String name;
    private Dish[] dishes;
    private Drink[] drinks;

    public Restaurant(String name, Dish[] dishes, Drink[] drinks) {
        this.name = name;
        this.dishes = dishes;
        this.drinks = drinks;
    }

    public void stampaMenu() {
        System.out.println("\nMenu del ristorante " + name + ".\n");

        System.out.println("Da mangiare abbiamo: \n");

        for (Dish dish : dishes) {
            System.out.println(dish.getNome() + ": " + dish.getPrezzo() + " euro\nIngredienti: " + dish.getIngredienti() + "\n");
        }

        System.out.println("Da bere abbiamo: \n");

        for (Drink drink : drinks) {
            System.out.println(drink.getNome() + ": " + drink.getPrezzo() + " euro\n");
        }
    }
}
