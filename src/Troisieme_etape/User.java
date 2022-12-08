package Troisieme_etape;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public static ArrayList<Contact> arrayContact = new ArrayList<>();

	// path database
	private static String database = "data/database.txt";

	// Texte generale
	public static String[] texte = { "nom", "prenom", "adresse", "telephone", "email", "reseau sociaux", "profession",
			"signe zodiaque", "lien parente", "fonction", "sortie" };

	public void printTexte(int nb) {
		for (int i = 0; i <= nb; i++)
			System.out.print("\n\t-" + premierCharMajuscule(texte[i]));
	}

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
	 * @brief AJOUTER CONTACT
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
		// String nom = scanner.nextLine();
		// Premier caractère Majuscule
		String nom = premierCharMajuscule(scanner.nextLine());

		// CONTROLE SI STRING
		if (isNumeric(nom)) {
			System.out.println("ERREUR: Inserez des character\n");
			return ajouterContact();
		}
		// CONTROLE SI NOM EXISTE
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
	 * @brief RECHERCHE
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
			if (up.equalsIgnoreCase(texte[1])) {
				contactUpdate.setPrenom(setTypeContact(listePrenom, up, 1));
			}

			// MODIFICATION ADRESSE
			if (up.equalsIgnoreCase(texte[2])) {
				System.out.println(texte[2] + " : ");
				contactUpdate.setAdresse(scannerUpdatdMod.nextLine());
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
				contactUpdate.setProfession(scannerUpdatdMod.nextLine());
			}

			// MODIFICATION SIGNE ZODIAC
			if (contactUpdate instanceof Amis) {
				if (up.equalsIgnoreCase(texte[7])) {
					Amis a = (Amis) contactUpdate;
					System.out.println(texte[7] + " : ");
					a.setSingeZodiacal(scannerUpdatdMod.nextLine());
				}
			}

			// MODIFICATION LIEN PARENTE
			if (contactUpdate instanceof Famille) {
				if (up.equalsIgnoreCase(texte[8])) {
					Famille f = (Famille) contactUpdate;
					System.out.println(texte[8] + " : ");
					f.setLienParent(scannerUpdatdMod.nextLine());
				}
			}
			// MODIFICATION FONCTION
			if (contactUpdate instanceof Professionnel) {
				if (up.equalsIgnoreCase(texte[9])) {
					Professionnel p = (Professionnel) contactUpdate;
					System.out.println(texte[9] + " : ");
					p.setFonction(scannerUpdatdMod.nextLine());
				}
			}
			// SORTIE
			if (up.equalsIgnoreCase(texte[10]) || up.equalsIgnoreCase("x")) {
				System.out.println("\nSortie Modification");
			}
		}
		// ORDRE GESTIONNALE
		ordre();
		return contactUpdate;

	}

	/**
	 * @brief CLEAN CONTACT
	 * @param nom
	 */
	public void supprimeContact(String nom) {

		// RECHERCHE CONTACT SI EXISTE
		if (existe(nom)) {
			if (save()) {
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
	public void supprimeAllContact(String nom) {

		arrayContact.removeAll(arrayContact);
		writeDate(arrayContact);
		System.out.println("\nGestionnaire vidé");

	}

	/**
	 * 
	 * @brief PREMIER CARACTERE MAJUSCULE
	 * @param string
	 * @return string avec premier lettre en majuscule
	 */
	public static String premierCharMajuscule(String string) {

		string = string.substring(0, 1).toUpperCase() + string.substring(1);
		return string;
	}

	/**
	 * @brief ORDRE GESTIONNAIRE
	 */
	private static void ordre() {

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
		writeDate(arrayContact);
	}

	/**
	 * @brief AFFICHAGE
	 */
	public void printContact() {
		ordre();
		arrayContact.forEach(System.out::println);
	}

	/**
	 * @brief RECHERCHE NOM SI EXISTE
	 * @param nomExiste nom a cherche
	 * @return true or false
	 */
	private static boolean existe(String nomExiste) {

		for (Contact c : arrayContact) {
			if (c.getNom().equals(nomExiste)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * @brief SET & MODIFICATION
	 * @param listeType
	 * @param up
	 * @param texteNb
	 * @return listeType
	 */
	private static ArrayList<String> setTypeContact(ArrayList<String> listeType, String up, int texteNb) {

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

			if (up.equalsIgnoreCase("email") || up.equalsIgnoreCase("e-mail")) {
				String espressione = "^[0-9a-z]([-_.]?[0-9a-z])*@[0-9a-z]([-.]?[0-9a-z])*.[a-z]{2,4}$";
				while (!type.matches(espressione)) {
					System.out.println("ERREUR: Inserez correct e-mail! Format: (xxxxx.xxxxx@xxxxx.xxx)2");
					System.out.println(texte[texteNb] + " : " + (i + 1));
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

	/**
	 * @brief LIRE FICHIER
	 * @param listIn
	 */
	public static void readData(ArrayList<Contact> listIn) {

		boolean endOfFile = false;
		Contact temp;

		try {

			FileInputStream ContactFile = new FileInputStream(database);
			ObjectInputStream contactStream = new ObjectInputStream(ContactFile);
			temp = (Contact) contactStream.readObject();

			while (endOfFile != true) {
				try {
					listIn.add(temp);
					temp = (Contact) contactStream.readObject();
				} catch (EOFException e) {
					endOfFile = true;
				}
			}
			contactStream.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("Contact file was not found");
		} catch (IOException e) {
			System.out.println("Contact file could not be read");
		} catch (ClassNotFoundException e) {
			System.out.println("Contact class was not found");
		}
	}

	/**
	 * @brief ECRIRE DANS UNE FICHIER
	 * @param listOut
	 */
	public static void writeDate(ArrayList<Contact> listOut) {

		try {
			FileOutputStream EmployeesFile = new FileOutputStream(database);
			ObjectOutputStream ContactStream = new ObjectOutputStream(EmployeesFile);
			for (Contact c : listOut) {
				ContactStream.writeObject(c);
			}
			ContactStream.close();
		} catch (IOException e) {
			// System.out.println("Error occurred while saving");
			e.printStackTrace();
		}
	}

	/**
	 * @brief
	 * @return true si enregistrer
	 */
	public Boolean save() {

		Scanner scannerSave = new Scanner(System.in);
		System.out.println("Voulez-vous enregistrer dans database ? [oui/non] ");

		String saveString = scannerSave.nextLine();

		if (saveString.equalsIgnoreCase("oui".trim()) || saveString.equalsIgnoreCase("o")) {
			writeDate(arrayContact);
			return true;
		} else if (saveString.equalsIgnoreCase("non".trim()) || saveString.equalsIgnoreCase("n")) {
			System.out.println("Enregistrement annulée");
			return false;
		}
		return false;
	}

}