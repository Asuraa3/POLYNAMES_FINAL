package backend.models;

public class Partie {
    private int id;
    private int scoreFinal;

    public Partie(int id, int scoreFinal) {
        this.id = id;
        this.scoreFinal = scoreFinal;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getScoreFinal() { return scoreFinal; }
    public void setScoreFinal(int scoreFinal) { this.scoreFinal = scoreFinal; }
}
