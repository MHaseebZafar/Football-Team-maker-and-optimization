public class Player {
    String   id;
    String   name;
    Position position;
    int      ranking;
    double   price;

    public Player(String id, String name, Position position, int ranking, double price) {
        this.id       = id;
        this.name     = name;
        this.position = position;
        this.ranking  = ranking;
        this.price    = price;
    }
}