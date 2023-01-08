package Troisieme_etape;

import java.io.IOException;

public class PetitMenu {

	/**
	 * @param action
	 * @param u
	 * @throws IOException
	 */
	public static void menu(int action, User u) {

		switch (action) {
		// INSERTION D'UN NOUVEAU CONTACT
		case 1:
			System.out.println(
					"Quel type de contact voulez-vous ajouter ? \n\t- [S] Standard \n\t- [A] Amis \n\t- [F] Famille \n\t- [P] Professionnel \n\t- [X] Sortie");

			String typeContact = Tools.scan();

			if (!Tools.isNumeric(typeContact)) {

				// TYPE STANDARD
				if (typeContact.equalsIgnoreCase("standard") || typeContact.equalsIgnoreCase("s")) {
					Standard c = User.newContact(Texte.texteBiographiques);
					u.appendContact(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession());
				}
				// TYPE AMIS
				else if (typeContact.equalsIgnoreCase("amis") || typeContact.equalsIgnoreCase("a")) {
					Contact c = User.newContact(Texte.texteBiographiques);
					// SIGNE ZODIAC
					System.out.println("Inserez votre " + Texte.texteBiographiques[7]);
					String signeZodiac = Tools.scan();

					u.appendAmis(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), signeZodiac.trim());

				}
				// TYPE FAMILLE
				else if (typeContact.equalsIgnoreCase("famille") || typeContact.equalsIgnoreCase("f")) {
					Contact c = User.newContact(Texte.texteBiographiques);
					// LIEN PARENT
					System.out.println("Inserez votre " + Texte.texteBiographiques[8]);
					String lienParent = Tools.scan();

					u.appendFamille(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), lienParent.trim());

				}
				// TYPE PROFESSIONNEL
				else if (typeContact.equalsIgnoreCase("professionnel") || typeContact.equalsIgnoreCase("p")) {
					Contact c = User.newContact(Texte.texteBiographiques);
					// FONCTION
					System.out.println("Inserez votre " + Texte.texteBiographiques[9]);
					String fonction = Tools.scan();

					u.appendProfessionnel(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), fonction.trim());

				}
				// TYPE SORTIE
				else if (typeContact.equalsIgnoreCase("sortie") || typeContact.equalsIgnoreCase("x")) {
					break;

				}
				// ERROR TYPE
			} else {
				System.out.println("ERREUR: Inserez le type correct!\n");
			}
			break;

		// AFFICHAGE DES CONTACTS
		case 2:
			if (!Tools.isEmpty()) {
				System.out.println("\nAffichage contacts");
				Tools.displayContact();
			}

			break;

		// SUPPRESSION D'UN CONTACT
		case 3:
			if (!Tools.isEmpty()) {
				System.out.println("Quel nom de contact voulez-vous supprime ? ");

				String nomSupprime = Tools.scan();
				while (Tools.isNumeric(nomSupprime)) {
					System.out.println("ERREUR: Inserez des character\n");
					System.out.println("Quel nom de contact voulez-vous supprime ? ");
					nomSupprime = Tools.scan();
				}
				u.deleteContact(Tools.firstCharUpperCase(nomSupprime).trim());

			}

			break;

		// MODIFICATION D'UN CONTACT
		case 4:
			if (!Tools.isEmpty()) {

				System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
				String nomUpdate = Tools.scan();
				while (Tools.isNumeric(nomUpdate)) {
					System.out.println("ERREUR: Inserez des character\n");
					System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
					nomUpdate = Tools.scan();
				}
				u.editContact(nomUpdate.trim(), Texte.texteBiographiques);
			}

			break;

		// RECHERCHE D'UN CONTACT
		case 5:
			if (!Tools.isEmpty()) {

				System.out.print("\nVoulez-vous faire une recherche par?:");
				Texte.displayTexteBio(10);
				System.out.println();
				String typeRecherche = Tools.scan();
				System.out.println("Quel " + typeRecherche + " voulez-vous recherche ? ");
				String stringRecherche = Tools.scan();
				u.findContact(typeRecherche.trim().toLowerCase(), stringRecherche.trim());
			}

			break;

		// SUPPRESSION TOUTS LES CONTACTS
		case 6:
			if (!Tools.isEmpty()) {

				System.out.println("Voulez-vous supprime touts la liste ? [oui/non] [o/n] ");

				String allSupprime = Tools.scan();

				if (allSupprime.equalsIgnoreCase("oui".trim()) || allSupprime.equalsIgnoreCase("o")) {
					u.deleteAllContact(allSupprime);
				} else if (allSupprime.equalsIgnoreCase("non".trim()) || allSupprime.equalsIgnoreCase("n")) {
					System.out.println("Suppression annulée");
				}
			}

			break;

		// SORTIE GESTIONNAIRE
		case 7:
			Database.save();
			System.out.println("Sortie Gestionnaire");
			System.exit(0);

		default:
			System.out.println("Inserez une nombre entre 1 & 7");
		}
	}
}
