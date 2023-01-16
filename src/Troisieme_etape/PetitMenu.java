package Troisieme_etape;

import java.io.IOException;

import Troisieme_etape.Texte.stringEnum;

public class PetitMenu {

	/**
	 * @param action
	 * @param u
	 * @throws IOException
	 */
	public static void menu(int action, User u) {

		switch (action) {
// INSERTION D'UN NOUVEAU CONTACT
		case Texte.INSERT_CONTACT:
			System.out.println(
					"Quel type de contact voulez-vous ajouter ? \n\t- [S] Standard \n\t- [A] Amis \n\t- [F] Famille \n\t- [P] Professionnel \n\t- [X] Sortie");

			String typeContact = Tools.scan();

			if (!Tools.isNumeric(typeContact)) {

				// TYPE STANDARD
				if (typeContact.equalsIgnoreCase("standard") || typeContact.equalsIgnoreCase("s")) {
					Contact c = User.newContact(Texte.texteBiographiques);
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
				System.err.println("ERREUR: Inserez le type correct!\n");
			}
			break;

// AFFICHAGE DES CONTACTS
		case Texte.DISPLAY_CONTACTS:
			if (!Tools.isEmpty()) {
				System.out.print("Affichage contacts:");
				Tools.displayContact();
			}

			break;

// SUPPRESSION D'UN CONTACT
		case Texte.DELETE_CONTACT:
			if (!Tools.isEmpty()) {
				System.out.println("Quel nom de contact voulez-vous supprime ? ");

				String nomDelete = Tools.scan();
				while (Tools.isNumeric(nomDelete)) {
					System.err.println("ERREUR: Inserez des character\n");
					System.out.println("Quel nom de contact voulez-vous supprime ? ");
					nomDelete = Tools.scan();
				}
				u.deleteContact(Tools.firstCharUpperCase(nomDelete).trim());
			}

			break;

// MODIFICATION D'UN CONTACT
		case Texte.MODIFY_CONTACT:
			if (!Tools.isEmpty()) {

				System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
				String nomUpdate = Tools.scan();
				while (Tools.isNumeric(nomUpdate)) {
					System.err.println("ERREUR: Inserez des character\n");
					System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
					nomUpdate = Tools.scan();
				}
				u.editContact(nomUpdate.trim(), Texte.texteBiographiques);
			}

			break;

// RECHERCHE D'UN CONTACT
		case Texte.SEARCH_CONTACT:
			try {
				if (!Tools.isEmpty()) {
					System.out.print("\nVoulez-vous faire une recherche par?:");
					Texte.displayTexteBio(10);
					System.out.println();
					Texte.stringEnum typeRecherche = Texte.stringEnum.valueOf(Tools.scan().trim().toUpperCase());
					if (typeRecherche != stringEnum.SORTIE) {
						System.out.println("Quel " + typeRecherche + " voulez-vous recherche ? ");
						String stringRecherche = Tools.scan();
						u.findContact(typeRecherche, stringRecherche.trim().toLowerCase());
					} else {
						System.out.println("Annulation recherche contact");
					}
				}
			} catch (Exception e) {
				System.err.println("ERROR: Contact non trouvé ");
			}

			break;

// SUPPRESSION TOUTS LES CONTACTS
		case Texte.DELETE_ALL_CONTACTS:
			if (!Tools.isEmpty()) {

				System.out.println("Voulez-vous supprime touts la liste ? [Oui/Non] [o/n]");

				String allSupprime = Tools.scan();

				if (allSupprime.equalsIgnoreCase("oui".trim()) || allSupprime.equalsIgnoreCase("o")) {
					u.deleteAllContact();
				} else if (allSupprime.equalsIgnoreCase("non".trim()) || allSupprime.equalsIgnoreCase("n")) {
					System.out.println("Suppression annulée");
				} else
					System.err.println("Commande annulée");
			}

			break;

// SORTIE GESTIONNAIRE
		case Texte.EXIT:
			Database.save();
			System.err.println("Sortie Gestionnaire");
			System.exit(0);

		default:
			System.out.println("Inserez une nombre entre 1 & 7");
		}
	}
}
