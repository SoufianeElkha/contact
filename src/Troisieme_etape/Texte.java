package Troisieme_etape;

public class Texte {

	// TEXTE MENU
	public static void displayMenu() {
		System.out.println("----------------------------------------------");
		System.out.println("\t MENU:\nQue voulez-vous faire : " + "\n [1]  \t Insertion d’un nouveau contact "
				+ "\n [2] \t Affichage des contacts " + "\n [3] \t Suppression d’un contact"
				+ "\n [4] \t Modification d’un contact " + "\n [5] \t Recherche d’un contact  "
				+ "\n [6] \t Suppression touts les contacts " + "\n [7] \t Sortie Gestionnaire");
		System.out.println("----------------------------------------------");

	}

	// TEXTE GENERALE
	public static String[] texteBiographiques = { "nom", "prenom", "adresse", "telephone", "email", "reseau sociaux",
			"profession", "signe zodiaque", "lien parente", "fonction", "sortie" };

	// PRINT TEXTE BIOGRAPHIQUES
	public static void displayTexteBio(int nb) {
		for (int i = 0; i <= nb; i++)
			System.out.print("\n\t-" + Tools.firstCharUpperCase(texteBiographiques[i]));
	}

}
