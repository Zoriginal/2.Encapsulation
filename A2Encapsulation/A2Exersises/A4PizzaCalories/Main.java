package A2Encapsulation.A2Exersises.A4PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Pizza pizza = new Pizza();
        try {
            pizza = new Pizza(input[1], Integer.parseInt(input[2]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        input = scan.nextLine().split("\\s+");
        try {
            Dough dough = new Dough(input[1], input[2], Integer.parseInt(input[3]));
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        input = scan.nextLine().split("\\s+");

        while (!input[0].equals("END")) {

            try {
                Topping topping = new Topping(input[1], Integer.parseInt(input[2]));
                pizza.addToppings(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            input = scan.nextLine().split("\\s+");
        }
        System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
    }
}
