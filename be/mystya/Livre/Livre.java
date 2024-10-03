package be.mystya.Livre;

public abstract class Livre {
    private String titre;
    private String auteur;
    private String isbn;
    private int anneeDeSortie;

    public Livre(String titre, String auteur, String isbn, int anneeDeSortie) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.anneeDeSortie = anneeDeSortie;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getISBN() {
        return isbn;
    }

    public int getAnneeDeSortie() {
        return anneeDeSortie;
    }


    public void afficherDetails() {
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Année de Sortie: " + getAnneeDeSortie());
    }
}
