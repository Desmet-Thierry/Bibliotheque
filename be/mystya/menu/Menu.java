package be.mystya.menu;

import be.mystya.Bibliotheque.Bibliotheque;
import be.mystya.Livre.Livre;
import be.mystya.Livre.Manga;
import be.mystya.Livre.Roman;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void afficherMenu() { // Renommé la méthode pour clarifier son objectif
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque(new ArrayList<>());
        Enregistrement enregistrement = new Enregistrement();

        enregistrement.creationDossierFichier();
        enregistrement.chargerBibliotheque(bibliotheque);

        boolean quit = false;
        while (!quit) {
            System.out.println("Menu :");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Afficher les livres");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez le type de livre (roman/manga) : ");
                    String type = scanner.nextLine();
                    System.out.print("Entrez le titre : ");
                    String titre = scanner.nextLine();
                    System.out.print("Entrez l'auteur : ");
                    String auteur = scanner.nextLine();
                    System.out.print("Entrez l'ISBN : ");
                    String isbn = scanner.nextLine();
                    System.out.print("Entrez l'année de publication : ");
                    int anneeDeSortie = scanner.nextInt();
                    scanner.nextLine(); // Consommer le retour à la ligne

                    // Créer et ajouter le livre
                    Livre livre = null;
                    switch (type.toLowerCase()) {
                        case "roman":
                            livre = new Roman(titre, auteur, isbn, anneeDeSortie, type);
                            break;
                        case "manga":
                            livre = new Manga(titre, auteur, isbn, anneeDeSortie, type);
                            break;
                        default:
                            System.out.println("Type de livre inconnu !");
                            break;
                    }
                    if (livre != null) {
                        bibliotheque.ajouterLivre(livre);
                    }
                    break;

                case 2:
                    System.out.print("Entrez le titre du livre à supprimer : ");
                    String titreASupprimer = scanner.nextLine();
                    bibliotheque.supprimerLivre(titreASupprimer);
                    break;

                case 3:
                    bibliotheque.afficherLivres();
                    break;

                case 0:
                    quit = true; // Modifié pour sortir de la boucle
                    break;

                default:
                    System.out.println("Option invalide !");
                    break;
            }
        }
        enregistrement.sauvegarderBibliotheque(bibliotheque);
        scanner.close();
        System.out.println("Programme terminé.");
    }
}
