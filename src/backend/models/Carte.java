package backend.models;

public class Carte {
    private int idCouleur;
    private int id;
    private int idMot;
    private int idPartie;

    public Carte(int i, Long motId, int id, int idCouleur) {
        this.id = id;
        this.idMot = idMot;
        this.idPartie = idPartie;
        this.idCouleur = idCouleur;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdMot() { return idMot; }
    public void setIdMot(int idMot) { this.idMot = idMot; }

    public int getIdPartie() { return idPartie; }
    public void setIdPartie(int idPartie) { this.idPartie = idPartie; }

    public int getIdCouleur() { return idCouleur; }
    public void setIdCouleur(int idCouleur) { this.idCouleur = idCouleur; }

    
}
