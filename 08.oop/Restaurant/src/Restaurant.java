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
        System.out.println("Menu del ristorante " + name + ":");

        System.out.println("Piatti:");

        for (Dish dish : dishes) {
            System.out.println(dish.getNome() + ": " + dish.getPrezzo() + " euro Ingredienti: " + dish.getIngredienti());
        }

        System.out.println("Bevande:");

        for (Drink drink : drinks) {
            System.out.println(drink.getNome() + ": " + drink.getPrezzo() + " euro");
        }
    }
}
