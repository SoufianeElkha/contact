package Troisieme_etape;

import java.util.HashMap;
import java.util.Map;

public class Texte {

	public static final int INSERT_CONTACT = 1;
	public static final int DISPLAY_CONTACTS = 2;
	public static final int DELETE_CONTACT = 3;
	public static final int MODIFY_CONTACT = 4;
	public static final int SEARCH_CONTACT = 5;
	public static final int DELETE_ALL_CONTACTS = 6;
	public static final int EXIT = 7;

	private static final Map<Integer, MenuOption> options = new HashMap<>();
	static {
		options.put(INSERT_CONTACT, new MenuOption(INSERT_CONTACT, "Insertion d’un nouveau contact"));
		options.put(DISPLAY_CONTACTS, new MenuOption(DISPLAY_CONTACTS, "Affichage des contacts"));
		options.put(DELETE_CONTACT, new MenuOption(DELETE_CONTACT, "Suppression d’un contact"));
		options.put(MODIFY_CONTACT, new MenuOption(MODIFY_CONTACT, "Modification d’un contact"));
		options.put(SEARCH_CONTACT, new MenuOption(SEARCH_CONTACT, "Recherche d’un contact"));
		options.put(DELETE_ALL_CONTACTS, new MenuOption(DELETE_ALL_CONTACTS, "Suppression touts les contacts"));
		options.put(EXIT, new MenuOption(EXIT, "Sortie Gestionnaire"));
	}

	// TEXTE MENU
	public static void displayMenu() {
		System.out.println("----------------------------------------------");
		System.out.println("\t MENU:\nQue voulez-vous faire : ");
		for (MenuOption option : options.values()) {
			System.out.println(" [" + option.getOption() + "] \t " + option.getText());
		}
		System.out.println("----------------------------------------------");
	}

// TEXTE GENERALE RECHERCHE ENUM
	public enum stringEnum {
		NOM, PRENOM, ADRESSE, TELEPHONE, EMAIL, RESEAUX_SOCIAUX, PROFESSION, SIGNE_ZODIAQUE, LIEN_PARENTE, FONCTION,
		SORTIE
	}

	// TEXTE GENERALE
	public static String[] texteBiographiques = { "nom", "prenom", "adresse", "telephone", "email", "reseau_sociaux",
			"profession", "signe_zodiaque", "lien_parente", "fonction", "sortie" };

	// PRINT TEXTE BIOGRAPHIQUES
	public static void displayTexteBio(int nb) {
		for (int i = 0; i <= nb; i++)
			System.out.print("\n\t-" + Tools.firstCharUpperCase(texteBiographiques[i]));
	}

}
