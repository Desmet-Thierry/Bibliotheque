package be.mystya.menu;

import be.mystya.Bibliotheque.Bibliotheque;
import be.mystya.Livre.Livre;
import be.mystya.Livre.Manga;
import be.mystya.Livre.Roman;

import java.io.*;

public class Enregistrement {
    String dossierPath = "C://Users//Desmet//Documents//JavaTestBiblio";
    String fichierPath = "C://Users//Desmet//Documents//JavaTestBiblio//MalisteDeLivre.txt";

    public void creationDossierFichier() {

        File ledossier = new File(dossierPath);
        File lefichier = new File(fichierPath);

        // Vérifier si le dossier existe, sinon le créer
        if (!ledossier.exists()) {
            if (ledossier.mkdirs()) {
                System.out.println("Dossier créé avec succès : " + dossierPath);
            } else {
                System.out.println("Échec de la création du dossier : " + dossierPath);
            }
        }

        // Vérifier si le fichier existe, sinon le créer
        if (!lefichier.exists()) {
            try {
                if (lefichier.createNewFile()) {
                    System.out.println("Fichier créé avec succès : " + fichierPath);
                } else {
                    System.out.println("Échec de la création du fichier : " + fichierPath);
                }
            } catch (IOException e) {
                System.out.println("Une erreur s'est produite lors de la création du fichier : " + fichierPath);
                e.printStackTrace();
            }
        }
    }

    public void chargerBibliotheque(Bibliotheque bibliotheque) {
        String fichierPath = "C://Users//Desmet//Documents//JavaTestBiblio//MalisteDeLivre.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierPath))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(",");
                if (parts.length >= 5) { // Vérifie que la ligne contient toutes les informations nécessaires
                    String type = parts[0].trim(); // Premier élément indique le type de livre
                    String titre = parts[1].trim();
                    String auteur = parts[2].trim();
                    String isbn = parts[3].trim();
                    int anneePublication = Integer.parseInt(parts[4].trim());

                    // Créer le livre en fonction du type
                    Livre livre = null;
                    if (type.equals("roman") && parts.length == 6) {
                        String genre = parts[5].trim();
                        livre = new Roman(titre, auteur, isbn, anneePublication, genre);
                    } else if (type.equals("manga") && parts.length == 6) { // Vérifie qu'il y a un dessinateur pour les mangas
                        String dessinateur = parts[5].trim();
                        livre = new Manga(titre, auteur, isbn, anneePublication, dessinateur);
                    }

                    if (livre != null) {
                        bibliotheque.ajouterLivre(livre);
                    }
                }
            }
            System.out.println("Bibliothèque chargée avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement de la bibliothèque.");
            e.printStackTrace();
        }
    }

    // Méthode pour sauvegarder tous les livres dans le fichier
    public void sauvegarderBibliotheque(Bibliotheque bibliotheque) {
        String fichierPath = "C://Users//Desmet//Documents//JavaTestBiblio//MalisteDeLivre.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierPath))) {
            for (Livre livre : bibliotheque.getLivres()) {
                // Vérifiez le type de livre
                if (livre instanceof Roman) {
                    writer.write("roman," + livre.getTitre() + "," + livre.getAuteur() + "," + livre.getISBN() + "," + livre.getAnneeDeSortie());
                } else if (livre instanceof Manga) {
                    Manga manga = (Manga) livre; // Cast vers Manga pour obtenir le dessinateur
                    writer.write("manga," + livre.getTitre() + "," + livre.getAuteur() + "," + livre.getISBN() + "," + livre.getAnneeDeSortie() + "," + manga.getDessinateur());
                }
                writer.newLine(); // Passe à la ligne suivante
            }
            System.out.println("Bibliothèque sauvegardée avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de la bibliothèque.");
            e.printStackTrace();
        }
    }
}