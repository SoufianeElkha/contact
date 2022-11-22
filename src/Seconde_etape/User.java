package Seconde_etape;

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
		}

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
	public Contact modificationContact(String nom) {

		ArrayList<String> listePrenom = new ArrayList<>();
		ArrayList<String> listeEmail = new ArrayList<>();
		ArrayList<String> listeRS = new ArrayList<>();
		ArrayList<String> listeTelephone = new ArrayList<>();

		Scanner scannerUpdatdNb = new Scanner(System.in);
		Scanner scannerUpdatdMod = new Scanner(System.in);

		// GET INDICE CONTACT A MODIFIER
		int index = -1;
		int ok = 0;
		Contact contactUpdate = null;

		for (Contact c : arrayContact) {
			if (c.getNom().equalsIgnoreCase(nom)) {
				index = arrayContact.indexOf(c);
				ok = 1;
				contactUpdate = arrayContact.get(index);
				break;
			}
		}

		if (ok == 0) {
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

			// PRENOM
			if (up.equalsIgnoreCase("Prenom")) {

				System.out.println("Combien de prenom ? ");
				int nbPrenom = scannerUpdatdNb.nextInt();

				for (int i = 0; i < nbPrenom; i++) {
					Scanner scannerPrenom = new Scanner(System.in);
					System.out.println("Prenom : " + (i + 1));
					String prenom = scannerPrenom.nextLine();
					listePrenom.add(prenom);
				}
				contactUpdate.setPrenom(listePrenom);
			}

			// ADRESSE
			if (up.equalsIgnoreCase("Adresse")) {
				System.out.println("Adresse : ");
				String adresse = scannerUpdatdMod.nextLine();
				contactUpdate.setAdresse(adresse);
			}

			// TELEPHONE
			if (up.equalsIgnoreCase("Telephone")) {

				System.out.println("Combien de numero telephone ? ");
				int nbEmail = scannerUpdatdNb.nextInt();

				for (int i = 0; i < nbEmail; i++) {
					Scanner scannerTelephone = new Scanner(System.in);
					System.out.println("Telephone : " + (i + 1));
					String telephone = scannerTelephone.nextLine();
					listeTelephone.add(telephone);
				}
				contactUpdate.setTelephone(listeTelephone);
			}

			// EMAIL
			if (up.equalsIgnoreCase("Email") || up.equalsIgnoreCase("E-mail")) {

				System.out.println("Combien de email ? ");
				int nbEmail = scannerUpdatdNb.nextInt();

				for (int i = 0; i < nbEmail; i++) {
					Scanner scannerEmail = new Scanner(System.in);
					System.out.println("Email : " + (i + 1));
					String email = scannerEmail.nextLine();
					listeEmail.add(email);
				}
				contactUpdate.setEmail(listeEmail);
			}

			// RESEAUX SOCIAUX
			if (up.equalsIgnoreCase("Reseaux Sociaux")) {

				System.out.println("Combien de reseaux Sociaux ? ");
				int nbRS = scannerUpdatdNb.nextInt();
				for (int i = 0; i <= nbRS; i++) {
					Scanner scannerRS = new Scanner(System.in);
					System.out.println("Email : " + i);
					String reseauxSociaux = scannerRS.nextLine();
					listeRS.add(reseauxSociaux);
				}
				contactUpdate.setReseauxSociaux(listeRS);
			}

			// PROFESSION
			if (up.equalsIgnoreCase("Profession")) {
				System.out.println("Profession : ");
				String profession = scannerUpdatdMod.nextLine();
				contactUpdate.setProfession(profession);
			}

			// SIGNE ZODIAC
			if (contactUpdate instanceof Amis) {
				if (up.equalsIgnoreCase("Signe zodiaque")) {
					Amis a = (Amis) contactUpdate;
					System.out.println("Signe zodiaque : ");
					String signeZod = scannerUpdatdMod.nextLine();
					a.setSingeZodiacal(signeZod);

				}
			}
			// LIEN PARENTE
			if (contactUpdate instanceof Famille) {
				if (up.equalsIgnoreCase("Lien parenté")) {
					Famille f = (Famille) contactUpdate;
					System.out.println("Lien parenté : ");
					String lienParent = scannerUpdatdMod.nextLine();
					f.setLienParent(lienParent);
				}
			}
			// FONCTION
			if (contactUpdate instanceof Professionnel) {
				if (up.equalsIgnoreCase("Fonction")) {
					Professionnel p = (Professionnel) contactUpdate;
					System.out.println("Fonction : ");
					String fonction = scannerUpdatdMod.nextLine();
					p.setFonction(fonction);
				}
			}
			if (up.equalsIgnoreCase("Sortie")) {
				System.out.println();
				System.out.println("Sortie Modification");
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

// Contrôle si est un caractère alphabétique
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