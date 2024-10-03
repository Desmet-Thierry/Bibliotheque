package be.mystya.Livre;

public class Roman extends Livre {
    private String genre;

    public Roman(String title, String auteur, String isbn, int anneeDeSortie, String genre) {
        super(title, auteur, isbn, anneeDeSortie);
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();

        System.out.println("Genre du roman: " + getGenre());

    }
}
