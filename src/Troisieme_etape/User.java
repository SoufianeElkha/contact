package Troisieme_etape;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public static ArrayList<Contact> arrayContact = new ArrayList<>();

	public void appendContact(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession) {
		Contact contact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
		arrayContact.add(contact);
	}

	public void appendAmis(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String signeZodiac) {

		Contact amis = new Amis(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession, signeZodiac);
		arrayContact.add(amis);
	}

	public void appendFamille(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String lienParent) {

		Contact famille = new Famille(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession, lienParent);
		arrayContact.add(famille);
	}

	public void appendProfessionnel(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String fonction) {

		Contact professionnel = new Famille(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession,
				fonction);
		arrayContact.add(professionnel);
	}

	/**
	 * 
	 * @param texteBiographiques
	 * @brief AJOUTER CONTACT
	 * @return Contact
	 */
	public static Contact newContact(String[] texteBiographiques) {
		// Initialisation variables insert contact

		Scanner scanner = new Scanner(System.in);
		ArrayList<String> listePrenom = new ArrayList<>();
		ArrayList<String> listeTelephone = new ArrayList<>();
		ArrayList<String> listeMail = new ArrayList<>();
		ArrayList<String> listeRS = new ArrayList<>();

		// NOM
		System.out.println("Inserez votre " + texteBiographiques[0] + ":");
		// String nom = scanner.nextLine();
		// Premier caractère Majuscule
		String nom = firstCharUpperCase(scanner.nextLine());

		// CONTROLE SI STRING
		if (isNumeric(nom)) {
			System.out.println("ERREUR: Inserez des character\n");
			return newContact(texteBiographiques);
		}
		// CONTROLE SI NOM existContact
		if (existContact(nom)) {
			System.out.println("ERROR: Le nom '" + nom + "' existContact déjà dans la liste.");
			return newContact(texteBiographiques);
		}
		// PRENOM
		System.out.println("Inserez votre " + texteBiographiques[1] + ":");
		setTypeContact(listePrenom, texteBiographiques[1], 1, texteBiographiques);

		// ADRESSE
		Scanner scannerAdresse = new Scanner(System.in);
		System.out.println("Inserez votre " + texteBiographiques[2] + ":");
		String adresse = scannerAdresse.nextLine();

		// TELEPHONE
		System.out.println("Inserez votre numero de " + texteBiographiques[3] + ":");
		setTypeContact(listeTelephone, texteBiographiques[3], 3, texteBiographiques);

		// E-MAIL
		System.out.println("Inserez votre " + texteBiographiques[4] + ":");
		setTypeContact(listeMail, texteBiographiques[4], 4, texteBiographiques);

		// RESEAUX SOCIAUX
		System.out.println("Inserez votre " + texteBiographiques[5] + ":");
		setTypeContact(listeRS, texteBiographiques[5], 5, texteBiographiques);

		// PROFESSION
		Scanner scannerProfession = new Scanner(System.in);
		System.out.println("Inserez votre " + texteBiographiques[6] + ":");
		String profession = scannerProfession.nextLine();

		// Premier caractère Majuscule
		profession = firstCharUpperCase(profession);

		// NOUVELLE CONTACT
		Contact c = new Contact(nom.trim(), listePrenom, adresse.trim(), listeTelephone, listeMail, listeRS,
				profession.trim());
		orderContact();
		return c;
	}

	/**
	 * @brief RECHERCHE
	 * @param typeRecherche
	 * @param stringRecherche
	 */
	public void findContact(String typeRecherche, String stringRecherche) {

		ArrayList<Integer> index = new ArrayList<>();

		switch (typeRecherche) {

		case "nom":

			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(firstCharUpperCase(stringRecherche))) {
					index.add(arrayContact.indexOf(c));
				}
			}

			break;

		case "prenom":
			for (Contact c : arrayContact) {
				if (c.getPrenom().contains(firstCharUpperCase(stringRecherche))) {
					index.add(arrayContact.indexOf(c));
				}
			}

			break;

		case "adresse":
			for (Contact c : arrayContact) {
				if (c.getAdresse().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "telephone":
			for (Contact c : arrayContact) {
				if (c.getTelephone().contains(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "reseau sociaux ":
			for (Contact c : arrayContact) {
				if (c.getReseauxSociaux().contains(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "email":
			for (Contact c : arrayContact) {
				if (c.getEmail().contains(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "e-mail":
			for (Contact c : arrayContact) {
				if (c.getEmail().contains(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "profession":
			for (Contact c : arrayContact) {
				if (c.getProfession().equalsIgnoreCase(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "signe zodiacal":
			for (Contact c : arrayContact) {
				Amis a = (Amis) c;
				if (a.getSigneZodiacal().equalsIgnoreCase(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;
		case "lien parental":
			for (Contact c : arrayContact) {
				Famille f = (Famille) c;
				if (f.getLienParent().equalsIgnoreCase(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "fonction":
			for (Contact c : arrayContact) {
				Professionnel p = (Professionnel) c;
				if (p.getFonction().equalsIgnoreCase(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}

			break;

		default:
			System.out.println("ERROR: erreur choix");

		}
		// SI INDEX EST VIDE
		if (index.isEmpty()) {
			System.out.println("ERROR: Contact non trouvé ");
		} else {

			for (int j = 0; j <= index.size() - 1; j++) {
				System.out.println();
				System.out.println(arrayContact.get(index.get(j)));
				System.out.println();
			}
		}
	}

	/**
	 * @brief MODIFICATION CONTACT
	 * @param nom
	 * @param texteBiographiques
	 * @return Contact modifie
	 */
	public Contact editContact(String nom, String[] texteBiographiques) {

		ArrayList<String> listePrenom = new ArrayList<>();
		ArrayList<String> listeEmail = new ArrayList<>();
		ArrayList<String> listeRS = new ArrayList<>();
		ArrayList<String> listeTelephone = new ArrayList<>();

		Scanner scannerUpdatdNb = new Scanner(System.in);
		Scanner scannerUpdatdMod = new Scanner(System.in);

		// GET INDICE CONTACT A MODIFIER
		int index = -1;
		Contact contactUpdate = null;

		for (Contact c : arrayContact) {
			if (c.getNom().equalsIgnoreCase(nom)) {
				index = arrayContact.indexOf(c);
				contactUpdate = arrayContact.get(index);
				System.out.println("Affichage du contact à modifier\n" + contactUpdate);
				break;
			}
		}

		// VERIFICATION RECHERCHE NOM
		if (index == -1) {
			System.out.println("ERROR: Nom '" + nom + "' non trouvé\n");

		} else {

			Scanner scannerUpdatd = new Scanner(System.in);
			System.out.print(
					"\nQuel champ voulez-vous modifier ? \n\t- Prenom \n\t- Adresse \n\t- Téléphone \n\t- E-mail \n\t- Reseaux Sociaux \n\t- Profession");
			if (contactUpdate instanceof Amis) {
				System.out.print("\n- Signe zodiaque");
			} else if (contactUpdate instanceof Famille) {
				System.out.print("\n- Lien parenté");
			} else if (contactUpdate instanceof Professionnel) {
				System.out.print("\n- Fonction");
			}
			System.out.print("\n\t[X] Sortie");
			System.out.println();
			String up = scannerUpdatd.nextLine();

			// MODIFICATION PRENOM
			if (up.equalsIgnoreCase(texteBiographiques[1])) {
				contactUpdate.setPrenom(setTypeContact(listePrenom, up, 1, texteBiographiques));
			}

			// MODIFICATION ADRESSE
			if (up.equalsIgnoreCase(texteBiographiques[2])) {
				System.out.println(texteBiographiques[2] + " : ");
				contactUpdate.setAdresse(scannerUpdatdMod.nextLine());
			}

			// MODIFICATION TELEPHONE
			if (up.equalsIgnoreCase(texteBiographiques[3])) {
				contactUpdate.setTelephone(setTypeContact(listeTelephone, up, 3, texteBiographiques));
			}

			// MODIFICATION EMAIL
			if (up.equalsIgnoreCase("E-mail") || up.equalsIgnoreCase(texteBiographiques[4])) {
				contactUpdate.setEmail(setTypeContact(listeEmail, up, 4, texteBiographiques));
			}

			// MODIFICATION RESEAUX SOCIAUX
			if (up.equalsIgnoreCase(texteBiographiques[5])) {
				contactUpdate.setReseauxSociaux(setTypeContact(listeRS, up, 5, texteBiographiques));
			}

			// MODIFICATION PROFESSION
			if (up.equalsIgnoreCase(texteBiographiques[6])) {
				System.out.println(texteBiographiques[6] + " : ");
				contactUpdate.setProfession(scannerUpdatdMod.nextLine());
			}

			// MODIFICATION SIGNE ZODIAC
			if (contactUpdate instanceof Amis) {
				if (up.equalsIgnoreCase(texteBiographiques[7])) {
					Amis a = (Amis) contactUpdate;
					System.out.println(texteBiographiques[7] + " : ");
					a.setSingeZodiacal(scannerUpdatdMod.nextLine());
				}
			}

			// MODIFICATION LIEN PARENTE
			if (contactUpdate instanceof Famille) {
				if (up.equalsIgnoreCase(texteBiographiques[8])) {
					Famille f = (Famille) contactUpdate;
					System.out.println(texteBiographiques[8] + " : ");
					f.setLienParent(scannerUpdatdMod.nextLine());
				}
			}
			// MODIFICATION FONCTION
			if (contactUpdate instanceof Professionnel) {
				if (up.equalsIgnoreCase(texteBiographiques[9])) {
					Professionnel p = (Professionnel) contactUpdate;
					System.out.println(texteBiographiques[9] + " : ");
					p.setFonction(scannerUpdatdMod.nextLine());
				}
			}
			// SORTIE
			if (up.equalsIgnoreCase(texteBiographiques[10]) || up.equalsIgnoreCase("x")) {
				System.out.println("\nSortie Modification");
			}
		}
		// orderContact GESTIONNALE
		orderContact();
		return contactUpdate;

	}

	/**
	 * @brief CLEAN CONTACT
	 * @param nom
	 */
	public void deleteContact(String nom) {

		// RECHERCHE CONTACT SI existContact
		if (existContact(nom)) {
			if (Database.save()) {
				arrayContact.removeIf(a -> (a.getNom().equals(nom)));
				System.out.println("\nContact " + nom + " supprimé");
			}
		} else {
			System.out.println("ERROR: Contact " + nom + " non trouvé");

		}
	}

	/**
	 * @brief CLEAN ALL CONTACT
	 * @param nom
	 */
	public void deleteAllContact(String nom) {

		arrayContact.removeAll(arrayContact);
		Database.writeDate(arrayContact);
		System.out.println("\nGestionnaire vidé");

	}

	/**
	 * 
	 * @brief PREMIER CARACTERE MAJUSCULE
	 * @param string
	 * @return string avec premier lettre en majuscule
	 */
	public static String firstCharUpperCase(String string) {

		return (string.substring(0, 1).toUpperCase() + string.substring(1));

	}

	/**
	 * @brief orderContact GESTIONNAIRE
	 */
	private static void orderContact() {

		Contact sort;
		for (int i = 0; i < arrayContact.size() - 1; i++) {
			for (int j = i + 1; j < arrayContact.size(); j++) {
				// COMPARE ELEMENT
				if (arrayContact.get(i).getNom().toUpperCase()
						.compareTo(arrayContact.get(j).getNom().toUpperCase()) >= 0) {
					// orderContact
					sort = arrayContact.get(i);
					arrayContact.set(i, arrayContact.get(j));
					arrayContact.set(j, sort);
				}
			}
		}
		Database.writeDate(arrayContact);
	}

	/**
	 * @brief AFFICHAGE
	 */
	public void displayContact() {
		orderContact();
		arrayContact.forEach(System.out::println);
	}

	/**
	 * @brief RECHERCHE NOM SI existContact
	 * @param nom nom a cherche
	 * @return true or false
	 */
	private static boolean existContact(String nom) {

		for (Contact c : arrayContact) {
			if (c.getNom().equals(nom)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * @brief SET & MODIFICATION
	 * @param listeType
	 * @param up
	 * @param type
	 * @param texteBiographiques
	 * @return listeType
	 */
	private static ArrayList<String> setTypeContact(ArrayList<String> listeType, String up, int txtNb,
			String[] texteBiographiques) {

		Scanner scannerUpdatdNb = new Scanner(System.in);

		System.out.println("Combien de " + texteBiographiques[txtNb] + " ? ");
		String stringNbType = scannerUpdatdNb.nextLine();
		if (!isNumeric(stringNbType.trim())) {
			System.out.println("ERREUR: Inserez des nombre\n");
			setTypeContact(listeType, up, txtNb, texteBiographiques);
		}
		int nbType = Integer.parseInt(stringNbType.trim());

		for (int i = 0; i < nbType; i++) {
			Scanner scannerUpdatdMod = new Scanner(System.in);
			System.out.println(texteBiographiques[txtNb] + ": " + (i + 1));
			String type = scannerUpdatdMod.nextLine();

			if (up.equalsIgnoreCase("telephone"))
				while (!isNumeric(type)) {
					System.out.println("ERREUR: Inserez des nombre\n");
					System.out.println(texteBiographiques[txtNb] + " : " + (i + 1));
					type = scannerUpdatdMod.nextLine();
				}

			if (up.equalsIgnoreCase("prenom") || up.equalsIgnoreCase("profession")
					|| up.equalsIgnoreCase("signe zodiaque") || up.equalsIgnoreCase("lien parente")
					|| up.equalsIgnoreCase("fonction")) {
				type = firstCharUpperCase(type);
				while (isNumeric(type)) {
					System.out.println("ERREUR: Inserez des character\n");
					System.out.println(texteBiographiques[txtNb] + " : " + (i + 1));
					type = scannerUpdatdMod.nextLine();
					type = firstCharUpperCase(type);
				}
			}

			if (up.equalsIgnoreCase("email") || up.equalsIgnoreCase("e-mail")) {
				String espressione = "^[0-9a-z]([-_.]?[0-9a-z])*@[0-9a-z]([-.]?[0-9a-z])*.[a-z]{2,4}$";
				while (!type.matches(espressione)) {
					System.out.println("ERREUR: Inserez correct e-mail! Format: (xxxxx.xxxxx@xxxxx.xxx)2");
					System.out.println(texteBiographiques[txtNb] + " : " + (i + 1));
					type = scannerUpdatdMod.nextLine();
				}
			}

			listeType.add(type.trim());
		}
		return listeType;
	}

	/**
	 * @brief VERIFICATION SI EST NOMBRE
	 * @param s
	 * @return true si est une nombre
	 */
	public static boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @brief VERIFICATION SI GESTIONNAIRE EST VIDE
	 * @return true si gestionnaire est vide
	 */
	public boolean isEmpty() {
		if (arrayContact.isEmpty()) {
			System.out.println("ERROR: Gestionnaire Vide");
			return true;
		}
		return false;
	}

}