package Seconde_etape;

import java.util.Scanner;

public class PetitMenu {

	/**
	 * @param action
	 * @param u
	 */
	public static void menu(int action, User u) {

		switch (action) {
		// Insertion d’un nouveau contact
		case 1:

			Scanner scannerMenu = new Scanner(System.in);
			System.out.println(
					"Quel type de contact voulez-vous ajouter ? \n\t- [S] Standard \n\t- [A] Amis \n\t- [F] Famille \n\t- [P] Professionnel");

			String typeContact = scannerMenu.nextLine();
			// TYPE STANDARD
			if (typeContact.equalsIgnoreCase("standard") || typeContact.equalsIgnoreCase("s")) {
				Contact c = User.ajouterContact();
				u.appendContact(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
						c.getReseauxSociaux(), c.getProfession());
			}
			// TYPE AMIS
			else if (typeContact.equalsIgnoreCase("amis") || typeContact.equalsIgnoreCase("a")) {
				Contact c = User.ajouterContact();
				// SIGNE ZODIAC
				System.out.println("Inserez votre signe zodiaque : ");
				String signeZodiac = scannerMenu.nextLine();

				u.appendAmis(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
						c.getReseauxSociaux(), c.getProfession(), signeZodiac.trim());

			}
			// TYPE FAMILLE
			else if (typeContact.equalsIgnoreCase("famille") || typeContact.equalsIgnoreCase("f")) {
				Contact c = User.ajouterContact();
				// LIEN PARENT
				System.out.println("Inserez votre lien de parentée : ");
				String lienParent = scannerMenu.nextLine();

				u.appendFamille(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
						c.getReseauxSociaux(), c.getProfession(), lienParent.trim());

			}
			// TYPE PROFESSIONNEL
			else if (typeContact.equalsIgnoreCase("professionnel") || typeContact.equalsIgnoreCase("p")) {
				Contact c = User.ajouterContact();
				// FONCTION
				System.out.println("Inserez votre fonction : ");
				String fonction = scannerMenu.nextLine();

				u.appendProfessionnel(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
						c.getReseauxSociaux(), c.getProfession(), fonction.trim());

			}
			// ERROR TYPE
			else {
				System.out.println("ERROR: Inserez le type correct!\n");
			}

			break;
		// Affichage des contacts
		case 2:
			if (u.arrayContact.isEmpty()) {
				System.out.println("ERROR: Gestionnaire Vide");
			} else {
				u.printContact();
			}

			break;
		// Suppression d’un contact
		case 3:
			if (u.arrayContact.isEmpty()) {
				System.out.println("ERROR: Gestionnaire Vide");
			} else {
				Scanner scannerSupprime = new Scanner(System.in);
				System.out.println("Quel nom de contact voulez-vous supprime ? ");

				String nomSupprime = scannerSupprime.nextLine();
				u.supprimeContact(nomSupprime.trim());
			}
			break;
		// Modification d’un contact
		case 4:
			if (u.arrayContact.isEmpty()) {
				System.out.println("ERROR: Gestionnaire Vide");
			} else {
				Scanner scannerUpdateC = new Scanner(System.in);
				System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
				String nomUpdate = scannerUpdateC.nextLine();
				u.modificationContact(nomUpdate.trim());
			}
			break;
		// Recherche d’un contact
		case 5:
			if (u.arrayContact.isEmpty()) {
				System.out.println("ERROR: Gestionnaire Vide");
			} else {

				Scanner scannerRecherche = new Scanner(System.in);
				Scanner scannerRechercheType = new Scanner(System.in);

				System.out.println("Recherche d'un contact");
				System.out.println(
						"\nVoulez-vous faire une recherche par?: \n Nom \n Prenom \n Adresse \n Telephone \n E-mail \n Reseau Sociaux \n Profession \n Signe zodiacal \n lien Parental \n Fonction");
				String typeRecherche = scannerRecherche.nextLine();

				System.out.println("Quel " + typeRecherche + " voulez-vous recherche ? ");
				String stringRecherche = scannerRechercheType.nextLine();
				u.rechercheContact(typeRecherche.trim().toLowerCase(), stringRecherche.trim());
			}

			break;
		// Suppression touts les contacts
		case 6:
			if (u.arrayContact.isEmpty()) {
				System.out.println("ERROR: Gestionnaire Vide");
			} else {
				Scanner scannerSupprime1 = new Scanner(System.in);
				System.out.println("Voulez-vous supprime touts la liste ? [oui/non] ");

				String allSupprime = scannerSupprime1.nextLine();

				if (allSupprime.equalsIgnoreCase("oui".trim()) || allSupprime.equalsIgnoreCase("o")) {
					u.supprimeAllContact(allSupprime);
				} else if (allSupprime.equalsIgnoreCase("non".trim()) || allSupprime.equalsIgnoreCase("n")) {
					System.out.println("Suppression annulée");
					// continue;
				}
			}
			break;
		// Sortie Gestionnaire
		case 7:
			System.out.println("Sortie Gestionnaire");
			System.exit(0);

		default:
			System.out.println("Inserez une nombre entre 1 & 7");
		}
	}
}
