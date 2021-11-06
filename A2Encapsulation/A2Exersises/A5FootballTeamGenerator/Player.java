package A2Encapsulation.A2Exersises.A5FootballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        exception(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        exception(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        exception(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        exception(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        exception(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.dribble + this.passing
                + this.shooting + this.sprint)/5.0;
    }

    private void exception(int data, String statsName) {
        if (data < 0 || data > 100) {
            throw new IllegalArgumentException(statsName + " should be between 0 and 100.");
        }
    }
}
