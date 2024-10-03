package be.mystya.Livre;

public class ManuelScolaire extends Livre{
    private String niveauScolaire;

    public ManuelScolaire(String title, String auteur, String isbn, int anneeDeSortie, String niveauScolaire) {
        super(title, auteur, isbn, anneeDeSortie);
        this.niveauScolaire = niveauScolaire;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    @Override
    public void afficherDetails(){
        super.afficherDetails();

        System.out.println("Niveau scolaire: " + getNiveauScolaire() );
    }
}
