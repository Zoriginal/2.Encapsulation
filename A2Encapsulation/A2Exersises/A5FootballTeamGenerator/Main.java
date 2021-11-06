package A2Encapsulation.A2Exersises.A5FootballTeamGenerator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Team> teamMap = new LinkedHashMap<>();

        while (!input.equals("END")) {

            String command = input.split(";")[0];
            String teamName = input.split(";")[1];
            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teamMap.putIfAbsent(teamName, team);
                        break;
                    case "Add":
                        if (!teamMap.containsKey(teamName)) {
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            Player player = new Player(input.split(";")[2], Integer.parseInt(input.split(";")[3]),
                                    Integer.parseInt(input.split(";")[4]), Integer.parseInt(input.split(";")[5]),
                                    Integer.parseInt(input.split(";")[6]), Integer.parseInt(input.split(";")[7]));
                            teamMap.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String player = input.split(";")[2];
                        teamMap.get(teamName).removePlayer(player);
                        break;
                    case "Rating":
                        if (!teamMap.containsKey(teamName)) {
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teamMap.get(teamName).getRating()));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scan.nextLine();
        }

    }
}
