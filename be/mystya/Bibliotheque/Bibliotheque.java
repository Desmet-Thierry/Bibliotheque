package be.mystya.Bibliotheque;

import be.mystya.Livre.Livre;

import java.util.ArrayList;

public class Bibliotheque {
    private final ArrayList<Livre> livres;

    public Bibliotheque(ArrayList<Livre> livres) {
        this.livres = new ArrayList<>(livres);
    }

    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public void ajouterLivre(Livre livre){
        livres.add(livre);

    }

    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("La bibliothèque est vide.");
        } else {
            System.out.println("Livres dans la bibliothèque :");
            for (Livre livre : livres) {
                System.out.println(livre.getTitre()); // Affiche le titre de chaque livre
            }
        }
    }

    public void supprimerLivre(String titre) {
        for (int i = 0; i < livres.size(); i++) {
            Livre livre = livres.get(i);
            if (livre.getTitre().equalsIgnoreCase(titre)) { // Comparaison insensible à la casse
                livres.remove(i);
                System.out.println("Livre supprimé : " + titre);
                return; // Sortir de la méthode après avoir supprimé
            }
        }
        System.out.println("Livre non trouvé : " + titre);
    }

}
