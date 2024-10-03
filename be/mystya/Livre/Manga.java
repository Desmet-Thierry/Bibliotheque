package be.mystya.Livre;

public class Manga extends Livre {
    private String dessinateur;

    public Manga(String titre, String auteur, String isbn, int anneeDeSortie, String dessinateur){
        super(titre,auteur,isbn,anneeDeSortie);

        this.dessinateur = dessinateur;
    }

    public String getDessinateur() {
        return dessinateur;
    }

    @Override
    public void afficherDetails(){
        super.afficherDetails();
        System.out.println("Dessinateur: " + getDessinateur());
    }
}
