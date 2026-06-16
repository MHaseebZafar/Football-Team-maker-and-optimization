import java.util.*;

public class Team {
    int    number;
    double budget;
    int    formationDEF, formationMID, formationATT;

    List<Player> players = new ArrayList<>();
    Stack<Player[]> history = new Stack<>();

    public Team(int number, double budget, int defs, int mids, int atts) {
        this.number       = number;
        this.budget       = budget;
        this.formationDEF = defs;
        this.formationMID = mids;
        this.formationATT = atts;
    }

    public int formationLimit(Position pos) {
        if (pos == Position.GK)  return 1;
        if (pos == Position.DEF) return formationDEF;
        if (pos == Position.MID) return formationMID;
        if (pos == Position.ATT) return formationATT;
        return 0;
    }

    public int countByPosition(Position pos) {
        int count = 0;
        for (Player p : players) {
            if (p.position == pos) count++;
        }
        return count;
    }

    public boolean contains(Player p) {
        for (Player t : players) {
            if (t.id.equals(p.id)) return true;
        }
        return false;
    }

    public String formationString() {
        return "1-" + formationDEF + "-" + formationMID + "-" + formationATT;
    }
}