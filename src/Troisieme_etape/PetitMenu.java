package Troisieme_etape;

import java.io.IOException;
import java.util.Scanner;

public class PetitMenu {

	/**
	 * @param action
	 * @param u
	 * @throws IOException
	 */
	public static void menu(int action, User u) throws IOException {

		switch (action) {
		// INSERTION D'UN NOUVEAU CONTACT
		case 1:

			Scanner scannerMenu = new Scanner(System.in);
			System.out.println(
					"Quel type de contact voulez-vous ajouter ? \n\t- [S] Standard \n\t- [A] Amis \n\t- [F] Famille \n\t- [P] Professionnel \n\t- [X] Sortie");

			String typeContact = scannerMenu.nextLine();

			if (!User.isNumeric(typeContact)) {

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
					System.out.println("Inserez votre " + User.texte[7]);
					String signeZodiac = scannerMenu.nextLine();

					u.appendAmis(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), signeZodiac.trim());

				}
				// TYPE FAMILLE
				else if (typeContact.equalsIgnoreCase("famille") || typeContact.equalsIgnoreCase("f")) {
					Contact c = User.ajouterContact();
					// LIEN PARENT
					System.out.println("Inserez votre " + User.texte[8]);
					String lienParent = scannerMenu.nextLine();

					u.appendFamille(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), lienParent.trim());

				}
				// TYPE PROFESSIONNEL
				else if (typeContact.equalsIgnoreCase("professionnel") || typeContact.equalsIgnoreCase("p")) {
					Contact c = User.ajouterContact();
					// FONCTION
					System.out.println("Inserez votre " + User.texte[9]);
					String fonction = scannerMenu.nextLine();

					u.appendProfessionnel(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), fonction.trim());

				}
				// TYPE SORTIE
				else if (typeContact.equalsIgnoreCase("sortie") || typeContact.equalsIgnoreCase("x")) {
					break;

				}
				// ERROR TYPE
			} else {
				System.out.println("ERROR: Inserez le type correct!\n");
			}
			break;

		// AFFICHAGE DES CONTACTS
		case 2:
			if (!u.isEmpty()) {
				System.out.println("\nAffichage contacts");
				u.printContact();
			}

			break;

		// SUPPRESSION D'UN CONTACT
		case 3:
			if (!u.isEmpty()) {
				Scanner scannerSupprime = new Scanner(System.in);
				try {

					System.out.println("Quel nom de contact voulez-vous supprime ? ");

					String nomSupprime = scannerSupprime.nextLine();
					while (User.isNumeric(nomSupprime)) {
						System.out.println("ERREUR: Inserez des character\n");
						System.out.println("Quel nom de contact voulez-vous supprime ? ");
						nomSupprime = scannerSupprime.nextLine();
					}
					u.supprimeContact(User.premierCharMajuscule(nomSupprime).trim());
				} catch (Exception e) {
					scannerSupprime.close();
				}
			}

			break;

		// MODIFICATION D'UN CONTACT
		case 4:
			if (!u.isEmpty()) {
				Scanner scannerUpdateC = new Scanner(System.in);
				try {

					System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
					String nomUpdate = scannerUpdateC.nextLine();
					while (User.isNumeric(nomUpdate)) {
						System.out.println("ERREUR: Inserez des character\n");
						System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
						nomUpdate = scannerUpdateC.nextLine();
					}
					u.modificationContact(nomUpdate.trim());
				} catch (Exception e) {
					scannerUpdateC.close();
				}
			}

			break;

		// RECHERCHE D'UN CONTACT
		case 5:
			if (!u.isEmpty()) {

				Scanner scannerRecherche = new Scanner(System.in);
				Scanner scannerRechercheType = new Scanner(System.in);
				try {

					System.out.println("Recherche d'un contact");
					System.out.println("\nVoulez-vous faire une recherche par?:");
					u.printTexte(10);
					System.out.println();
					String typeRecherche = scannerRechercheType.next();
					System.out.println("Quel " + typeRecherche + " voulez-vous recherche ? ");
					String stringRecherche = scannerRecherche.next();
					u.rechercheContact(typeRecherche.trim().toLowerCase(), stringRecherche.trim());
				} catch (Exception e) {
					scannerRecherche.close();
					scannerRechercheType.close();
				}
			}

			break;

		// SUPPRESSION TOUTS LES CONTACTS
		case 6:
			if (!u.isEmpty()) {
				Scanner scannerSupprime1 = new Scanner(System.in);
				try {

					System.out.println("Voulez-vous supprime touts la liste ? [oui/non] ");

					String allSupprime = scannerSupprime1.nextLine();

					if (allSupprime.equalsIgnoreCase("oui".trim()) || allSupprime.equalsIgnoreCase("o")) {
						u.supprimeAllContact(allSupprime);
					} else if (allSupprime.equalsIgnoreCase("non".trim()) || allSupprime.equalsIgnoreCase("n")) {
						System.out.println("Suppression annulée");
					}
				} catch (Exception e) {
					scannerSupprime1.close();
				}
			}

			break;

		// SORTIE GESTIONNAIRE
		case 7:
			u.save();
			System.out.println("Sortie Gestionnaire");
			System.exit(0);

		default:
			System.out.println("Inserez une nombre entre 1 & 7");
		}
	}
}
