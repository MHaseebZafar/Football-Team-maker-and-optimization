import java.util.*;

public class TeamSystem {
    private Map<String, Player> database = new HashMap<>();
    private List<Team> allTeams = new ArrayList<>();
    private Team activeTeam;
    private Scanner scanner;

    public TeamSystem(Scanner scanner) {
        this.scanner = scanner;
        loadPlayers();
    }

    private void loadPlayers() {
        // Goalkeepers
        addToDatabase(new Player("G1",  "Alisson",          Position.GK,  89, 1.2));
        addToDatabase(new Player("G2",  "Ederson",          Position.GK,  88, 1.1));
        addToDatabase(new Player("G3",  "Martinez",         Position.GK,  85, 0.8));
        addToDatabase(new Player("G4",  "Kelleher",         Position.GK,  78, 0.4));
        addToDatabase(new Player("G5",  "Raya",             Position.GK,  83, 0.7));
        addToDatabase(new Player("G6",  "Pope",             Position.GK,  84, 0.9));
        addToDatabase(new Player("G7",  "Pickford",         Position.GK,  82, 0.7));
        addToDatabase(new Player("G8",  "Flekken",          Position.GK,  80, 0.5));

        // Defenders
        addToDatabase(new Player("D1",  "Van Dijk",         Position.DEF, 90, 2.0));
        addToDatabase(new Player("D2",  "Dias",             Position.DEF, 89, 1.9));
        addToDatabase(new Player("D3",  "Saliba",           Position.DEF, 87, 1.6));
        addToDatabase(new Player("D4",  "Alexander-Arnold", Position.DEF, 88, 1.8));
        addToDatabase(new Player("D5",  "Konate",           Position.DEF, 84, 1.0));
        addToDatabase(new Player("D6",  "Ake",              Position.DEF, 83, 0.9));
        addToDatabase(new Player("D7",  "Trippier",         Position.DEF, 85, 1.1));
        addToDatabase(new Player("D8",  "White",            Position.DEF, 85, 1.2));
        addToDatabase(new Player("D9",  "Timber",           Position.DEF, 84, 1.0));
        addToDatabase(new Player("D10", "Pedro Porro",      Position.DEF, 83, 0.9));
        addToDatabase(new Player("D11", "Dunk",             Position.DEF, 82, 0.7));
        addToDatabase(new Player("D12", "Gomez",            Position.DEF, 80, 0.6));
        addToDatabase(new Player("D13", "Bradley",          Position.DEF, 79, 0.5));
        addToDatabase(new Player("D14", "Maguire",          Position.DEF, 78, 0.4));

        // Midfielders
        addToDatabase(new Player("M1",  "De Bruyne",        Position.MID, 91, 2.2));
        addToDatabase(new Player("M2",  "Rodri",            Position.MID, 90, 2.1));
        addToDatabase(new Player("M3",  "Bellingham",       Position.MID, 89, 2.0));
        addToDatabase(new Player("M4",  "Palmer",           Position.MID, 88, 1.8));
        addToDatabase(new Player("M5",  "Rice",             Position.MID, 87, 1.7));
        addToDatabase(new Player("M6",  "Fernandes",        Position.MID, 86, 1.4));
        addToDatabase(new Player("M7",  "Mac Allister",     Position.MID, 86, 1.5));
        addToDatabase(new Player("M8",  "Szoboszlai",       Position.MID, 84, 1.2));
        addToDatabase(new Player("M9",  "Mbeumo",           Position.MID, 84, 1.1));
        addToDatabase(new Player("M10", "Trossard",         Position.MID, 83, 1.0));
        addToDatabase(new Player("M11", "Joelinton",        Position.MID, 81, 0.7));
        addToDatabase(new Player("M12", "Endo",             Position.MID, 81, 0.6));
        addToDatabase(new Player("M13", "Mainoo",           Position.MID, 79, 0.5));
        addToDatabase(new Player("M14", "Andreas P.",       Position.MID, 79, 0.5));

        // Attackers
        addToDatabase(new Player("A1",  "Mbappe",           Position.ATT, 92, 2.5));
        addToDatabase(new Player("A2",  "Haaland",          Position.ATT, 91, 2.4));
        addToDatabase(new Player("A3",  "Salah",            Position.ATT, 90, 2.2));
        addToDatabase(new Player("A4",  "Saka",             Position.ATT, 88, 1.9));
        addToDatabase(new Player("A5",  "Foden",            Position.ATT, 87, 1.8));
        addToDatabase(new Player("A6",  "Isak",             Position.ATT, 87, 1.6));
        addToDatabase(new Player("A7",  "Son",              Position.ATT, 87, 1.5));
        addToDatabase(new Player("A8",  "Watkins",          Position.ATT, 86, 1.5));
        addToDatabase(new Player("A9",  "Diaz",             Position.ATT, 85, 1.4));
        addToDatabase(new Player("A10", "Nunez",            Position.ATT, 83, 1.2));
        addToDatabase(new Player("A11", "Rashford",         Position.ATT, 84, 1.1));
        addToDatabase(new Player("A12", "Gakpo",            Position.ATT, 82, 1.0));
        addToDatabase(new Player("A13", "Wilson",           Position.ATT, 81, 0.7));
        addToDatabase(new Player("A14", "Nketiah",          Position.ATT, 79, 0.5));
    }

    private void addToDatabase(Player p) {
        database.put(p.id, p);
    }

    private boolean isGloballyLocked(Player p) {
        for (Team t : allTeams) {
            if (t.contains(p)) return true;
        }
        return false;
    }

    private boolean isInActiveTeam(Player p) {
        return activeTeam != null && activeTeam.contains(p);
    }

    private String getStatus(Player p) {
        for (Team t : allTeams) {
            if (t.contains(p)) return "[TEAM " + t.number + "]";
        }
        return "Available";
    }

    private void printHeader() {
        System.out.println(String.format("%-5s | %-18s | %-4s | %-6s | %-9s | %s",
                "ID", "NAME", "POS", "RANK", "PRICE", "STATUS"));
        System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
    }

    private void printPlayer(Player p, String status) {
        System.out.printf("%-5s | %-18s | %-4s | %-6d | $%-8.2f | %s%n",
                p.id, p.name, p.position, p.ranking, p.price, status);
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a whole number.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a number like 10.5");
            }
        }
    }

    public void start() {
        while (true) {
            System.out.println("\n -!-!-!-FOOTBALL TEAM MAKER-!-!-!-");
            System.out.println("Teams created: " + allTeams.size());
            System.out.println("1. Create New Team");
            System.out.println("2. View / Manage Teams");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine().trim();
            if (choice.equals("1"))      createTeamMenu();
            else if (choice.equals("2")) manageTeamsMenu();
            else if (choice.equals("3")) break;
            else System.out.println("Invalid option. Enter 1, 2, or 3.");
        }
    }

    private void createTeamMenu() {
        int teamNumber = allTeams.size() + 1;
        System.out.println("\n-!-!-!- CREATING TEAM " + teamNumber + " -!-!-!-");

        System.out.println("\n--- All Players [Order is random] ---");
        printHeader();
        List<Player> shuffled = new ArrayList<>(database.values());
        Collections.shuffle(shuffled);
        for (Player p : shuffled) {
            printPlayer(p, getStatus(p));
        }

        double budget = readDouble("\nEnter budget in millions (e.g. 15.0): ");

        System.out.println("\nDefine Formation. DEF + MID + ATT must equal 10.");
        System.out.println("(GK will be picked manually after the 10 outfield players are drafted.)");

        int defs, mids, atts;
        while (true) {
            defs = readInt("  Defenders:   ");
            mids = readInt("  Midfielders: ");
            atts = readInt("  Attackers:   ");

            if (defs + mids + atts != 10) {
                System.out.println("  Error: Must add up to 10. Try again.");
            } else if (defs < 2 || mids < 2 || atts < 1) {
                System.out.println("  Error: Minimum is 2 DEF, 2 MID, 1 ATT. Try again.");
            } else {
                break;
            }
        }

        activeTeam = new Team(teamNumber, budget, defs, mids, atts);
        allTeams.add(activeTeam);

        Comparator<Player> byRankingDesc = new Comparator<Player>() {
            public int compare(Player a, Player b) {
                return Integer.compare(b.ranking, a.ranking);
            }
        };
        PriorityQueue<Player> defQueue = new PriorityQueue<>(byRankingDesc);
        PriorityQueue<Player> midQueue = new PriorityQueue<>(byRankingDesc);
        PriorityQueue<Player> attQueue = new PriorityQueue<>(byRankingDesc);

        for (Player p : database.values()) {
            if (p.position == Position.DEF && !isGloballyLocked(p)) defQueue.add(p);
            if (p.position == Position.MID && !isGloballyLocked(p)) midQueue.add(p);
            if (p.position == Position.ATT && !isGloballyLocked(p)) attQueue.add(p);
        }

        System.out.println("\n--- Auto-Drafting Outfield Players ---");
        draftPosition(Position.DEF, defs, defQueue);
        draftPosition(Position.MID, mids, midQueue);
        draftPosition(Position.ATT, atts, attQueue);

        System.out.println("\n--- Outfield draft done! Now pick your Goalkeeper. ---");
        pickGoalkeeperManually();

        System.out.printf("%nTeam %d created! %d/11 players. Remaining budget: $%.2fm%n",
                teamNumber, activeTeam.players.size(), activeTeam.budget);
    }

    private void draftPosition(Position pos, int needed, PriorityQueue<Player> queue) {
        int drafted = 0;

        while (drafted < needed && !queue.isEmpty()) {
            Player top = queue.peek();

            if (isInActiveTeam(top)) {
                queue.poll();
                continue;
            }

            if (top.price > activeTeam.budget) {
                System.out.printf("\n[HALT] Can't afford %s ($%.2fm). Balance: $%.2fm%n",
                        top.name, top.price, activeTeam.budget);
                System.out.println("1. Allow negative balance");
                System.out.println("2. Pick a cheaper player yourself");
                System.out.println("3. Skip this slot");
                System.out.print("Choose (1/2/3): ");
                String choice = scanner.nextLine().trim();

                if (choice.equals("1")) {
                    queue.poll();
                    addPlayerToTeam(activeTeam, top, null);
                    drafted++;
                } else if (choice.equals("2")) {
                    boolean picked = pickPlayerManually(pos);
                    if (picked) drafted++;
                    queue.poll();
                } else {
                    System.out.println("Skipping remaining " + pos + " slots.");
                    break;
                }

            } else {
                queue.poll();
                addPlayerToTeam(activeTeam, top, null);
                drafted++;
            }
        }
    }

    private void pickGoalkeeperManually() {
        System.out.println("\n--- Available Goalkeepers ---");
        printHeader();

        List<Player> gks = new ArrayList<>();
        for (Player p : database.values()) {
            if (p.position == Position.GK) gks.add(p);
        }
        Collections.sort(gks, new Comparator<Player>() {
            public int compare(Player a, Player b) {
                return Integer.compare(b.ranking, a.ranking);
            }
        });
        for (Player p : gks) {
            printPlayer(p, getStatus(p));
        }

        while (true) {
            System.out.print("\nEnter GK ID (or CANCEL to skip): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("CANCEL")) {
                System.out.println("GK slot left empty.");
                return;
            }

            Player chosen = database.get(input);

            if (chosen == null || chosen.position != Position.GK) {
                System.out.println("Invalid ID or not a GK. Try again.");
            } else if (isInActiveTeam(chosen)) {
                System.out.println("That GK is already in your team.");
            } else if (isGloballyLocked(chosen)) {
                System.out.println("That GK is in " + getStatus(chosen) + ". Pick another.");
            } else {
                addPlayerToTeam(activeTeam, chosen, null);
                return;
            }
        }
    }

    private boolean pickPlayerManually(Position pos) {
        System.out.println("\n--- Available " + pos + "s ---");
        printHeader();

        for (Player p : database.values()) {
            if (p.position == pos) printPlayer(p, getStatus(p));
        }

        while (true) {
            System.out.print("Enter ID (or CANCEL to skip): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("CANCEL")) return false;

            Player chosen = database.get(input);

            if (chosen == null || chosen.position != pos) {
                System.out.println("Invalid ID or wrong position.");
            } else if (isGloballyLocked(chosen)) {
                System.out.println("Locked in " + getStatus(chosen) + ". Pick another.");
            } else {
                addPlayerToTeam(activeTeam, chosen, null);
                return true;
            }
        }
    }

    private void addPlayerToTeam(Team team, Player added, Player removedPlayer) {
        team.players.add(added);
        team.budget -= added.price;
        System.out.printf("  -> Added: %-18s (Balance: $%.2fm)%n", added.name, team.budget);
        team.history.push(new Player[]{removedPlayer, added});
    }

    private void manageTeamsMenu() {
        if (allTeams.isEmpty()) {
            System.out.println("\nNo teams yet. Create one first (option 1).");
            return;
        }

        while (true) {
            System.out.println("\n-!-!-!-ALL TEAMS -!-!-!-");
            for (Team t : allTeams) {
                System.out.printf("  [%d] Team %d | %d/11 players | Formation: %s | Budget: $%.2fm%n",
                        t.number, t.number, t.players.size(), t.formationString(), t.budget);
            }
            System.out.println("  [0] Back to Main Menu");

            int choice = readInt("Select team number: ");
            if (choice == 0) return;

            if (choice < 1 || choice > allTeams.size()) {
                System.out.println("Invalid number. Try again.");
                continue;
            }

            activeTeam = allTeams.get(choice - 1);
            viewTeamMenu();
        }
    }

    private void viewTeamMenu() {
        while (true) {
            System.out.printf("%n=== TEAM %d | %d/11 players | Formation: %s | Budget: $%.2fm ===%n",
                    activeTeam.number, activeTeam.players.size(),
                    activeTeam.formationString(), activeTeam.budget);
            printHeader();
            for (Player p : activeTeam.players) {
                printPlayer(p, "[IN TEAM]");
            }

            System.out.println("\n1. Change a player");
            System.out.println("2. Fill an empty slot");
            System.out.println("3. Undo last change");
            System.out.println("4. Back to team list");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1"))      changePlayer();
            else if (choice.equals("2")) fillEmptySlot();
            else if (choice.equals("3")) undoLastChange();
            else if (choice.equals("4")) break;
            else System.out.println("Invalid choice.");
        }
    }

    private void changePlayer() {
        System.out.print("Enter ID of player to REMOVE: ");
        String removeId = scanner.nextLine().trim().toUpperCase();

        Player toRemove = null;
        for (Player p : activeTeam.players) {
            if (p.id.equals(removeId)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove == null) {
            System.out.println("Player not found in your team.");
            return;
        }

        activeTeam.players.remove(toRemove);
        activeTeam.budget += toRemove.price;
        System.out.printf("%s removed. Balance: $%.2fm%n", toRemove.name, activeTeam.budget);

        System.out.println("\n--- Available " + toRemove.position + " Replacements ---");
        printHeader();
        for (Player p : database.values()) {
            if (p.position == toRemove.position) printPlayer(p, getStatus(p));
        }

        while (true) {
            System.out.print("Enter ID of new player (or CANCEL to restore original): ");
            String addId = scanner.nextLine().trim().toUpperCase();

            if (addId.equals("CANCEL")) {
                activeTeam.players.add(toRemove);
                activeTeam.budget -= toRemove.price;
                System.out.println(toRemove.name + " restored. No changes made.");
                return;
            }

            Player toAdd = database.get(addId);

            if (toAdd == null || toAdd.position != toRemove.position) {
                System.out.println("Invalid ID or wrong position. Try again.");
            } else if (isGloballyLocked(toAdd)) {
                System.out.println(toAdd.name + " is in " + getStatus(toAdd) + ". Pick another.");
            } else {
                addPlayerToTeam(activeTeam, toAdd, toRemove);
                System.out.println("Swap complete!");
                return;
            }
        }
    }

    private void fillEmptySlot() {
        if (activeTeam.players.size() >= 11) {
            System.out.println("Team is already full (11 players).");
            return;
        }

        System.out.print("Which position to fill? (GK / DEF / MID / ATT): ");
        String input = scanner.nextLine().trim().toUpperCase();

        Position pos;
        try {
            pos = Position.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid position. Use GK, DEF, MID, or ATT.");
            return;
        }

        if (activeTeam.countByPosition(pos) >= activeTeam.formationLimit(pos)) {
            System.out.printf("Already have the max %s players (%d) in this formation.%n",
                    pos, activeTeam.formationLimit(pos));
            return;
        }

        if (pos == Position.GK) pickGoalkeeperManually();
        else pickPlayerManually(pos);
    }

    private void undoLastChange() {
        if (activeTeam.history.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Player[] lastAction  = activeTeam.history.pop();
        Player   wasRemoved  = lastAction[0];
        Player   wasAdded    = lastAction[1];

        activeTeam.players.remove(wasAdded);
        activeTeam.budget += wasAdded.price;
        System.out.printf("Removed: %s ($%.2fm refunded)%n", wasAdded.name, wasAdded.price);

        if (wasRemoved != null) {
            activeTeam.players.add(wasRemoved);
            activeTeam.budget -= wasRemoved.price;
            System.out.printf("Restored: %s%n", wasRemoved.name);
        }

        System.out.printf("Undo done! Balance: $%.2fm%n", activeTeam.budget);
    }
}