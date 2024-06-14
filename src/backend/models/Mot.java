package backend.models;

public class Mot {
    private int id;
    private String texteMot;

    public Mot(int id, String texteMot) {
        this.id = id;
        this.texteMot = texteMot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexteMot() {
        return texteMot;
    }

    public void setTexteMot(String texteMot) {
        this.texteMot = texteMot;
    }
}
