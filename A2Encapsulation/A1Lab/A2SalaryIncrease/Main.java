package A2Encapsulation.A1Lab.A2SalaryIncrease;

import A2Encapsulation.A1Lab.A1SortByNameAndAge.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            people.add(new Person(firstName, lastName, age, salary));
        }
        double bonus = Double.parseDouble(reader.readLine());

        DecimalFormat format = new DecimalFormat("##.0##");

        people.forEach(person -> {
            person.increaseSalary(bonus);
            System.out.printf("%s %s gets %s leva%n", person.getFirstName(), person.getLastName(), format.format(person.getSalary()));
        });
    }
}
