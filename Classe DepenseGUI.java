import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepensesGUI extends JFrame {
    private GestionnaireDepenses gestionnaire;
    private DefaultListModel<String> listModel;
    private JList<String> depensesList;
    private JTextField categorieField, montantField, dateField, descriptionField;

    public DepensesGUI() {
        gestionnaire = new GestionnaireDepenses();
        setTitle("Gestion des Dépenses");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal
        setLayout(new BorderLayout());

        // Liste des dépenses
        listModel = new DefaultListModel<>();
        depensesList = new JList<>(listModel);
        add(new JScrollPane(depensesList), BorderLayout.CENTER);

        // Panel d'ajout
        JPanel panelAjout = new JPanel(new GridLayout(5, 2));
        panelAjout.add(new JLabel("Catégorie:"));
        categorieField = new JTextField();
        panelAjout.add(categorieField);

        panelAjout.add(new JLabel("Montant:"));
        montantField = new JTextField();
        panelAjout.add(montantField);

        panelAjout.add(new JLabel("Date:"));
        dateField = new JTextField();
        panelAjout.add(dateField);

        panelAjout.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        panelAjout.add(descriptionField);

        JButton ajouterButton = new JButton("Ajouter");
        panelAjout.add(ajouterButton);

        JButton supprimerButton = new JButton("Supprimer");
        panelAjout.add(supprimerButton);

        add(panelAjout, BorderLayout.SOUTH);

        // Action du bouton Ajouter
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categorie = categorieField.getText();
                double montant = Double.parseDouble(montantField.getText());
                String date = dateField.getText();
                String description = descriptionField.getText();

                Depense depense = new Depense(categorie, montant, date, description);
                gestionnaire.ajouterDepense(depense);
                listModel.addElement(depense.toString());

                // Effacer les champs après ajout
                categorieField.setText("");
                montantField.setText("");
                dateField.setText("");
                descriptionField.setText("");
            }
        });

        // Action du bouton Supprimer
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = depensesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    gestionnaire.supprimerDepense(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DepensesGUI().setVisible(true));
    }
}
