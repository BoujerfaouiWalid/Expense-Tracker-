import java.util.ArrayList;

public class GestionnaireDepenses {
    private ArrayList<Depense> depenses = new ArrayList<>();

    public void ajouterDepense(Depense depense) {
        depenses.add(depense);
    }

    public void supprimerDepense(int index) {
        if (index >= 0 && index < depenses.size()) {
            depenses.remove(index);
        }
    }

    public ArrayList<Depense> getDepenses() {
        return depenses;
    }
}
