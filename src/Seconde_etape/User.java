package Seconde_etape;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public static ArrayList<Contact> arrayContact = new ArrayList<>();

	/**
	 * Texte generale
	 */
	static String[] texte = { "nom", "prenom", "adresse", "telephone", "email", "reseau sociaux", "profession",
			"signe zodiaque", "lien parente", "fonction", "sortie" };

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
	 * AJOUTER CONTACT
	 * 
	 * @return Contact
	 */
	public static Contact ajouterContact() {
		// Initialisation variables insert contact

		Scanner scanner = new Scanner(System.in);
		ArrayList<String> listePrenom = new ArrayList<>();
		ArrayList<String> listeTelephone = new ArrayList<>();
		ArrayList<String> listeMail = new ArrayList<>();
		ArrayList<String> listeRS = new ArrayList<>();

		// NOM
		System.out.println("Inserez votre " + texte[0] + ":");
		String nom = scanner.nextLine();
		// Premier caractère Majuscule
		nom = premierCharMajuscule(nom);

		// CONTROLE SI STRING
		if (isNumeric(nom)) {
			System.out.println("ERREUR: Inserez des character\n");
			return ajouterContact();
		}
		// CONTROLE
		if (existe(nom)) {
			System.out.println("ERROR: Le nom '" + nom + "' existe déjà dans la liste.");
			return ajouterContact();
		}
		// PRENOM
		System.out.println("Inserez votre " + texte[1] + ":");
		setTypeContact(listePrenom, texte[1], 1);

		// ADRESSE
		Scanner scannerAdresse = new Scanner(System.in);
		System.out.println("Inserez votre " + texte[2] + ":");
		String adresse = scannerAdresse.nextLine();

		// TELEPHONE
		System.out.println("Inserez votre numero de " + texte[3] + ":");
		setTypeContact(listeTelephone, texte[3], 3);

		// E-MAIL
		System.out.println("Inserez votre " + texte[4] + ":");
		setTypeContact(listeMail, texte[4], 4);

		// RESEAUX SOCIAUX
		System.out.println("Inserez votre " + texte[5] + ":");
		setTypeContact(listeRS, texte[5], 5);

		// PROFESSION
		Scanner scannerProfession = new Scanner(System.in);
		System.out.println("Inserez votre " + texte[6] + ":");
		String profession = scannerProfession.nextLine();

		// Premier caractère Majuscule
		profession = premierCharMajuscule(profession);

		// NOUVELLE CONTACT
		Contact c = new Contact(nom.trim(), listePrenom, adresse.trim(), listeTelephone, listeMail, listeRS,
				profession.trim());
		ordre();
		return c;
	}

	/**
	 * RECHERCHE
	 * 
	 * @param typeRecherche
	 * @param stringRecherche
	 */
	public void rechercheContact(String typeRecherche, String stringRecherche) {

		ArrayList<Integer> index = new ArrayList<>();

		switch (typeRecherche) {

		case "nom":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(premierCharMajuscule(stringRecherche))) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "prenom":
			for (Contact c : arrayContact) {
				if (c.getPrenom().contains(premierCharMajuscule(stringRecherche))) {
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
	 * MODIFICATION CONTACT
	 * 
	 * @param nom
	 * @return Contact modifie
	 */
	public Contact modificationContact(String nom) {

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
			if (c.getNom().equalsIgnoreCase(nom.trim())) {
				index = arrayContact.indexOf(c);
				contactUpdate = arrayContact.get(index);
				System.out.println("Affichage du contact à modifier\n" + contactUpdate);
				break;
			}
		}

		// VERIFICATION RECHERCHE NOM
		if (index == -1) {
			System.out.println("ERROR: Nom " + nom + " non trouvé\n");

		} else {

			Scanner scannerUpdatd = new Scanner(System.in);
			System.out.print(
					"\nQuel champ voulez-vous modifier ? \n- Prenom \n- Adresse \n- Téléphone \n- E-mail \n- Reseaux Sociaux \n- Profession");
			if (contactUpdate instanceof Amis) {
				System.out.print("\n- Signe zodiaque");
			} else if (contactUpdate instanceof Famille) {
				System.out.print("\n- Lien parenté");
			} else if (contactUpdate instanceof Professionnel) {
				System.out.print("\n- Fonction");
			}
			System.out.print("\n\n- SORTIE");
			System.out.println();
			String up = scannerUpdatd.nextLine();

			// MODIFICATION PRENOM
			if (up.equalsIgnoreCase(texte[1])) {
				contactUpdate.setPrenom(setTypeContact(listePrenom, up, 1));
			}

			// MODIFICATION ADRESSE
			if (up.equalsIgnoreCase(texte[2])) {
				System.out.println(texte[2] + " : ");
				String adresse = scannerUpdatdMod.nextLine();
				contactUpdate.setAdresse(adresse);
			}

			// MODIFICATION TELEPHONE
			if (up.equalsIgnoreCase(texte[3])) {
				contactUpdate.setTelephone(setTypeContact(listeTelephone, up, 3));
			}

			// MODIFICATION EMAIL
			if (up.equalsIgnoreCase("E-mail") || up.equalsIgnoreCase(texte[4])) {
				contactUpdate.setEmail(setTypeContact(listeEmail, up, 4));
			}

			// MODIFICATION RESEAUX SOCIAUX
			if (up.equalsIgnoreCase(texte[5])) {
				contactUpdate.setReseauxSociaux(setTypeContact(listeRS, up, 5));
			}

			// MODIFICATION PROFESSION
			if (up.equalsIgnoreCase(texte[6])) {
				System.out.println(texte[6] + " : ");
				String profession = scannerUpdatdMod.nextLine();
				contactUpdate.setProfession(profession);
			}

			// MODIFICATION SIGNE ZODIAC
			if (contactUpdate instanceof Amis) {
				if (up.equalsIgnoreCase(texte[7])) {
					Amis a = (Amis) contactUpdate;
					System.out.println(texte[7] + " : ");
					String signeZod = scannerUpdatdMod.nextLine();
					a.setSingeZodiacal(signeZod);
				}
			}

			// MODIFICATION LIEN PARENTE
			if (contactUpdate instanceof Famille) {
				if (up.equalsIgnoreCase(texte[8])) {
					Famille f = (Famille) contactUpdate;
					System.out.println(texte[8] + " : ");
					String lienParent = scannerUpdatdMod.nextLine();
					f.setLienParent(lienParent);
				}
			}
			// MODIFICATION FONCTION
			if (contactUpdate instanceof Professionnel) {
				if (up.equalsIgnoreCase(texte[9])) {
					Professionnel p = (Professionnel) contactUpdate;
					System.out.println(texte[9] + " : ");
					String fonction = scannerUpdatdMod.nextLine();
					p.setFonction(fonction);
				}
			}
			// SORTIE
			if (up.equalsIgnoreCase(texte[10])) {
				System.out.println("\nSortie Modification");
			}
		}
		// ORDRE GESTIONNALE
		ordre();
		return contactUpdate;

	}

	/**
	 * CLEAN CONTACT
	 * 
	 * @param nom
	 */
	public void supprimeContact(String nom) {

		// RECHERCHE CONTACT SI EXISTE
		if (existe(nom)) {
			int indice = 0;
			for (Contact c : arrayContact) {
				if (c.getNom().equals(nom)) {
					indice = arrayContact.indexOf(c);
				}
			}
			arrayContact.remove(indice);
			System.out.println("\nContact " + nom + " supprimé");
		} else {
			System.out.println("ERROR: Contact " + nom + " non trouvé");

		}
	}

	/**
	 * CLEAN ALL CONTACT
	 * 
	 * @param nom
	 */
	public void supprimeAllContact(String nom) {

		arrayContact.removeAll(arrayContact);
		System.out.println("\nGestionnaire vidé");

	}

	/**
	 * PREMIER CARACTERE MAJUSCULE
	 * 
	 * @param string
	 * @return string avec premier lettre en majuscule
	 */
	public static String premierCharMajuscule(String string) {

		string = string.substring(0, 1).toUpperCase() + string.substring(1);
		return string;
	}

	/**
	 * ORDRE GESTIONNAIRE
	 */
	public static void ordre() {
		Contact sort;
		for (int i = 0; i < arrayContact.size() - 1; i++) {
			for (int j = i + 1; j < arrayContact.size(); j++) {
				// COMPARE ELEMENT
				if (arrayContact.get(i).getNom().toUpperCase()
						.compareTo(arrayContact.get(j).getNom().toUpperCase()) >= 0) {
					// ORDRE
					sort = arrayContact.get(i);
					arrayContact.set(i, arrayContact.get(j));
					arrayContact.set(j, sort);
				}
			}
		}
	}

	/**
	 * AFFICHAGE
	 */
	public void printContact() {

		System.out.println("\nAffichage contacts");
		for (Contact c : arrayContact)
			System.out.println(c);
	}

	/**
	 * RECHERCHE NOM SI EXISTE
	 * 
	 * @param nomExiste nom a cherche
	 * @return true or false
	 */
	public static boolean existe(String nomExiste) {
		for (Contact c : arrayContact) {
			if (c.getNom().equals(nomExiste)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * SET & MODIFICATION
	 * 
	 * @param listeType
	 * @param up
	 * @param texteNb
	 * @return listeType
	 */
	public static ArrayList<String> setTypeContact(ArrayList<String> listeType, String up, int texteNb) {

		Scanner scannerUpdatdNb = new Scanner(System.in);

		System.out.println("Combien de " + texte[texteNb] + " ? ");
		String stringNbType = scannerUpdatdNb.nextLine();
		if (!isNumeric(stringNbType.trim())) {
			System.out.println("ERREUR: Inserez des nombre\n");
			setTypeContact(listeType, up, texteNb);
		}
		int nbType = Integer.parseInt(stringNbType.trim());

		for (int i = 0; i < nbType; i++) {
			Scanner scannerUpdatdMod = new Scanner(System.in);
			System.out.println(texte[texteNb] + ": " + (i + 1));
			String type = scannerUpdatdMod.nextLine();

			if (up.equalsIgnoreCase("telephone"))
				while (!isNumeric(type)) {
					System.out.println("ERREUR: Inserez des nombre\n");
					System.out.println(texte[texteNb] + " : " + (i + 1));
					type = scannerUpdatdMod.nextLine();
				}

			if (up.equalsIgnoreCase("prenom") || up.equalsIgnoreCase("profession")
					|| up.equalsIgnoreCase("signe zodiaque") || up.equalsIgnoreCase("lien parente")
					|| up.equalsIgnoreCase("fonction")) {
				type = premierCharMajuscule(type);
				while (isNumeric(type)) {
					System.out.println("ERREUR: Inserez des character\n");
					System.out.println(texte[texteNb] + " : " + (i + 1));
					type = scannerUpdatdMod.nextLine();
					type = premierCharMajuscule(type);
				}
			}
			listeType.add(type.trim());
		}
		return listeType;
	}

	/**
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

}