public class Depense {
    private String categorie;
    private double montant;
    private String date;
    private String description;

    public Depense(String categorie, double montant, String date, String description) {
        this.categorie = categorie;
        this.montant = montant;
        this.date = date;
        this.description = description;
    }

    public String getCategorie() { return categorie; }
    public double getMontant() { return montant; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return categorie + " - " + montant + "€ - " + date + " - " + description;
    }
}
