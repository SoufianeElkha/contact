package Seconde_etape;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public static ArrayList<Contact> arrayContact = new ArrayList<>();

	// Texte generale
	String[] texte = { "nom", "prenom", "adresse", "telephone", "email", "reseau sociaux", "profession",
			"signe zodiaque", "lien parenté", "fonction" };

	public void appendContact(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession) {
		Contact contact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
		arrayContact.add(contact);
	}

	public void appendAmis(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String singeZodiac) {

		Contact amis = new Amis(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession, singeZodiac);
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

	public static boolean existe(String nomExiste) {
		for (Contact c : arrayContact) {
			if (c.getNom().equals(nomExiste)) {
				return true;
			}
		}
		return false;
	}

// AJOUTER CONTACT
	public static Contact ajouterContact() {
		// Initialisation variables insert contact

		Scanner scanner = new Scanner(System.in);

		ArrayList<String> listePrenom = new ArrayList<>();
		ArrayList<String> listeTelephone = new ArrayList<>();
		ArrayList<String> listeMail = new ArrayList<>();
		ArrayList<String> listeRS = new ArrayList<>();

		// NOM
		System.out.println("Inserez votre nom : ");
		String nom = scanner.nextLine();
		if (estChar(nom) == false) {
			System.out.println("ERREUR: Inserez des character\n");
			return ajouterContact();
		}

		// CONTROLE
		if (existe(nom)) {
			System.out.println("Le nom existe");
			return ajouterContact();
		}
		// PRENOM
		System.out.println("Inserez votre prenom. Combien ?");
		int nbPrenom = scanner.nextInt();

		for (int i = 0; i < nbPrenom; i++) {
			Scanner scannerPrenom = new Scanner(System.in);
			System.out.println("Prenom : " + (i + 1));
			String prenom = scannerPrenom.nextLine();
			while (estChar(prenom) == false) {
				System.out.println("ERREUR: Inserez des character\n");
				System.out.println("Prenom : " + (i + 1));
				prenom = scannerPrenom.nextLine();
			}

			listePrenom.add(prenom);
		}

		// ADRESSE
		Scanner scannerAdresse = new Scanner(System.in);
		System.out.println("Inserez votre adresse : ");
		String adresse = scannerAdresse.nextLine();

		// TELEPHONE
		System.out.println("Inserez votre numéro de téléphone. Combien ?");
		int nbTelephone = scanner.nextInt();
		for (int i = 0; i < nbTelephone; i++) {
			Scanner scannerTelephone = new Scanner(System.in);
			System.out.println("Téléphone : " + (i + 1));
			String telephone = scannerTelephone.nextLine();
			while (estNb(telephone) == false) {
				System.out.println("ERREUR: Inserez des nombres\n");
				System.out.println("Téléphone : " + (i + 1));
				telephone = scannerTelephone.nextLine();
			}
			listeTelephone.add(telephone);
		}

		// MAIL
		System.out.println("Inserez votre mail. Combien ?");
		int nbMail = scanner.nextInt();

		for (int i = 0; i < nbMail; i++) {
			Scanner scannerEmail = new Scanner(System.in);
			System.out.println("E-mail : " + (i + 1));
			String mail = scannerEmail.nextLine();
			listeMail.add(mail);
		}

		// RESEAUX SOCIAUX
		System.out.println("Inserez votre réseau social. Combien ?");

		int nbRS = scanner.nextInt();

		for (int i = 0; i < nbRS; i++) {
			Scanner scannerRS = new Scanner(System.in);
			System.out.println("Réseau social : " + (i + 1));
			String rs = scannerRS.nextLine();
			listeRS.add(rs);
		}

		// PROFESSION
		Scanner scannerProfession = new Scanner(System.in);
		System.out.println("Inserez votre profession : ");
		String profession = scannerProfession.nextLine();

		Contact c = new Contact(nom, listePrenom, adresse, listeTelephone, listeMail, listeRS, profession);
		ordre();
		return c;
	}

// AFFICHAGE
	public void printContact() {

		System.out.println("Affichage contacts");
		for (Contact c : arrayContact) {
			System.out.println("\n" + c + "\n");
		}
	}

// CLEAN CONTACT
	public void supprimeContact(String nom) {
		if (arrayContact.isEmpty()) {
			System.out.println("ERROR: Gestionnaire Vide");
		} else if (existe(nom)) {
			int indice = 0;
			for (Contact c : arrayContact) {
				if (c.getNom().equals(nom)) {
					indice = arrayContact.indexOf(c);
				}
			}
			arrayContact.remove(indice);
			System.out.println("\nContact supprimé");
		} else {
			System.out.println("ERROR: Contact non trouvé");

		}
	}

// CLEAN ALL CONTACT
	public void supprimeAllContact(String nom) {
		if (arrayContact.isEmpty()) {
			System.out.println("ERROR: Gestionnaire Vide");
		} else {
			arrayContact.removeAll(arrayContact);
			System.out.println("\nGestionnaire vidé");
		}

	}

// MODIFICATION
	public ArrayList<String> modification(Contact contactUpdate, ArrayList<String> listeType, String up, int texteNb) {

		Scanner scannerUpdatdNb = new Scanner(System.in);

		System.out.println("Combien de " + texte[texteNb] + " ? ");
		int nbType = scannerUpdatdNb.nextInt();

		for (int i = 0; i < nbType; i++) {
			Scanner scannerUpdatdMod = new Scanner(System.in);
			System.out.println(texte[texteNb] + ": " + (i + 1));
			String type = scannerUpdatdMod.nextLine();

			if (up.equalsIgnoreCase("prenom") || up.equalsIgnoreCase("profession")) {
				while (estChar(texte[texteNb]) == false) {
					System.out.println("ERREUR: Inserez des character\n");
					System.out.println("Prenom : " + (i + 1));
					type = scannerUpdatdMod.nextLine();
				}
			}
			listeType.add(type);
		}
		return listeType;
	}

// RECHERCHE
	public void rechercheContact(String typeRecherche, String stringRecherche) {

		ArrayList<Integer> index = new ArrayList<>();

		switch (typeRecherche.toLowerCase()) {

		case "nom":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "prenom":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "adresse":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "telephone":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "reseau sociaux ":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "email":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "e-mail":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		case "profession":
			for (Contact c : arrayContact) {
				if (c.getNom().startsWith(stringRecherche)) {
					index.add(arrayContact.indexOf(c));
				}
			}
			break;

		default:
			System.out.println("ERROR: erreur choix");
			;
		}

		for (int j = 0; j <= index.size() - 1; j++) {
			System.out.println();
			System.out.println(arrayContact.get(index.get(j)));
			System.out.println();
		}
		if (index.isEmpty()) {
			System.out.println("ERROR: Contact non trouvé ");
		}
	}

// MODIFICATION CONTACT
// Return nouveau contact modifié
	public Contact modificationContact(String nom) {

		ArrayList<String> listePrenom = new ArrayList<>();
		ArrayList<String> listeEmail = new ArrayList<>();
		ArrayList<String> listeRS = new ArrayList<>();
		ArrayList<String> listeTelephone = new ArrayList<>();

		Scanner scannerUpdatdNb = new Scanner(System.in);
		Scanner scannerUpdatdMod = new Scanner(System.in);

		// GET INDICE CONTACT A MODIFIER
		int index = -1;
		int trouve = -1;
		Contact contactUpdate = null;

		for (Contact c : arrayContact) {
			if (c.getNom().equalsIgnoreCase(nom)) {
				index = arrayContact.indexOf(c);
				trouve = 0;
				contactUpdate = arrayContact.get(index);
				break;
			}
		}

		// Vérification recherche Nom
		if (trouve == -1) {
			System.out.println("ERROR: Nom non trouvé\n");

		} else {

			Scanner scannerUpdatd = new Scanner(System.in);
			System.out.print(
					"Quel champ voulez-vous modifier ? \nPrenom \nAdresse \nTéléphone \nEmail \nReseaux Sociaux \nProfession");
			if (contactUpdate instanceof Amis) {
				System.out.print("\nSigne zodiaque");
			} else if (contactUpdate instanceof Famille) {
				System.out.print("\nLien parenté");
			} else if (contactUpdate instanceof Professionnel) {
				System.out.print("\nFonction");
			}
			System.out.print("\nSortie");
			System.out.println();
			String up = scannerUpdatd.nextLine();

			// MODIFICATION PRENOM
			if (up.equalsIgnoreCase(texte[1])) {
				contactUpdate.setPrenom(modification(contactUpdate, listePrenom, up, 1));
			}

			// MODIFICATION ADRESSE
			if (up.equalsIgnoreCase(texte[2])) {
				System.out.println(texte[2] + " : ");
				String adresse = scannerUpdatdMod.nextLine();
				contactUpdate.setAdresse(adresse);
			}

			// MODIFICATION TELEPHONE
			if (up.equalsIgnoreCase(texte[3])) {
				contactUpdate.setTelephone(modification(contactUpdate, listeTelephone, up, 3));
			}

			// MODIFICATION EMAIL
			if (up.equalsIgnoreCase("E-mail") || up.equalsIgnoreCase(texte[4])) {
				contactUpdate.setEmail(modification(contactUpdate, listeEmail, up, 4));
			}

			// MODIFICATION RESEAUX SOCIAUX
			if (up.equalsIgnoreCase(texte[5])) {
				contactUpdate.setReseauxSociaux(modification(contactUpdate, listeRS, up, 5));
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
			if (up.equalsIgnoreCase("Sortie")) {
				System.out.println("\nSortie Modification");
			}
		}

		ordre();
		return contactUpdate;

	}

// ORDRE GESTIONNAIRE
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

	public static boolean estNb(String nb) {
		boolean controle = (nb != null && nb.matches("(\\+)?[0-9]+$"));
		return controle;
	}

// CONTROLE SI EST UNE CARACTERE ALPHABETIQUE
// Return True or FALSE
	public static boolean estChar(String s) {
		if (s == null) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
				return false;
			}
		}
		return true;
	}

}