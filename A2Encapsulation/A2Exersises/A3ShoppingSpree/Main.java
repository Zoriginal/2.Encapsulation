package A2Encapsulation.A2Exersises.A3ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] peoples = scan.nextLine().split(";");
        Map<String, Person> peoplesMap = new LinkedHashMap<>();

        for (String person : peoples) {
            String personName = person.split("=")[0];
            double personMoney = Double.parseDouble(person.split("=")[1]);
            try {
                Person person1 = new Person(personName, personMoney);
                peoplesMap.put(personName, person1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] products = scan.nextLine().split(";");
        Map<String, Product> productsMap = new LinkedHashMap<>();

        for (String product : products) {
            String productName = product.split("=")[0];
            double productPrice = Double.parseDouble(product.split("=")[1]);
            try {
                Product product1 = new Product(productName, productPrice);
                productsMap.put(productName, product1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String data = scan.nextLine();

        while (!data.equals("END")) {

            String personName = data.split(" ")[0];
            String productName = data.split(" ")[1];

            try {
                peoplesMap.get(personName).buyProduct(productsMap.get(productName));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            data = scan.nextLine();
        }

        for (Person person : peoplesMap.values()) {
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            }
            System.out.println(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
    }
}

