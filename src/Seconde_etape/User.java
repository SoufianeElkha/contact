package Seconde_etape;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public ArrayList<Contact> arrayContact = new ArrayList<>();
	// public ArrayList<Amis> arrayAmis = new ArrayList<>();

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

		// PRENOM
		System.out.println("Inserez votre prenom. Combien ?");
		int nbPrenom = scanner.nextInt();

		for (int i = 0; i <= nbPrenom; i++) {
			System.out.println("Prenom : " + (i + 1));
			String prenom = scanner.nextLine();
			listePrenom.add(prenom);
		}

		// ADRESSE
		System.out.println("Inserez votre adresse : ");
		String adresse = scanner.nextLine();

		// TELEPHONE
		System.out.println("Inserez votre numéro de téléphone. Combien ?");
		int nbTelephone = scanner.nextInt();
		for (int i = 0; i <= nbTelephone; i++) {
			System.out.println("Téléphone : " + i);
			String telephone = scanner.nextLine();
			if (!estChar(telephone)) {
				listeTelephone.add(telephone);
			} else {
				System.out.println("Inserez de valeur numerique");
			}
		}

		// MAIL
		System.out.println("Inserez votre mail. Combien ?");
		int nbMail = scanner.nextInt();

		for (int i = 0; i <= nbMail; i++) {
			System.out.println("Mail : " + i);
			String mail = scanner.nextLine();
			listeMail.add(mail);
		}

		// RESEAUX SOCIAUX
		System.out.println("Inserez votre réseau social. Combien ?");
		int nbRS = scanner.nextInt();

		for (int i = 0; i <= nbRS; i++) {
			System.out.println("Réseau social : " + i);
			String rs = scanner.nextLine();
			listeRS.add(rs);
		}

		// PROFESSION
		System.out.println("Inserez votre profession : ");
		String profession = scanner.nextLine();

		Contact c = new Contact(nom, listePrenom, adresse, listeTelephone, listeMail, listeRS, profession);
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

		int indice = 0;
		for (Contact c : arrayContact) {
			if (c.getNom().equals(nom)) {
				indice = arrayContact.indexOf(c);
			}
		}
		arrayContact.remove(indice);
	}

	// CLEAN ALL CONTACT
	public void supprimeAllContact(String nom) {
		arrayContact.removeAll(arrayContact);
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
			System.out.println("Erreur choix");
			;
		}

		for (int j = 0; j <= index.size() - 1; j++) {
			System.out.println(arrayContact.get(index.get(j)));
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
		Amis contactUpdateAmis = null;

		for (Contact c : arrayContact) {
			if (c.getNom().equalsIgnoreCase(nom)) {
				index = arrayContact.indexOf(c);
				ok = 1;
				contactUpdate = arrayContact.get(index);
				break;
			}
		}

		/*
		 * for (Contact c : arrayContact) { if (c.getNom().equalsIgnoreCase(nom)) {
		 * index = arrayContact.indexOf(c); ok = 1; contactUpdateAmis =
		 * arrayAmis.get(index); break; } }
		 */

		if (ok == 0) {
			System.out.println("Nom non trouvé\n");
		} else {
			Scanner scannerUpdatd = new Scanner(System.in);
			System.out.println(
					"Quel champ voulez-vous modifier ? \nPrenom \nAdresse \nTéléphone \nEmail \nReseaux Sociaux \nProfession \nSortie ");
			String up = scannerUpdatd.nextLine();

			// PRENOM
			if (up.equalsIgnoreCase("Prenom")) {

				System.out.println("Combien de prenom ? ");
				int nbPrenom = scannerUpdatdNb.nextInt();

				for (int i = 0; i <= nbPrenom; i++) {
					System.out.println("Prenom : " + i);
					String prenom = scannerUpdatdMod.nextLine();
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

				System.out.println("Combien de email ? ");
				int nbEmail = scannerUpdatdNb.nextInt();

				for (int i = 0; i <= nbEmail; i++) {
					System.out.println("Email : " + i);
					String telephone = scannerUpdatdMod.nextLine();
					listeTelephone.add(telephone);
				}
				contactUpdate.setTelephone(listeTelephone);
			}

			// EMAIL
			if (up.equalsIgnoreCase("Email") || up.equalsIgnoreCase("E-mail")) {

				System.out.println("Combien de email ? ");
				int nbEmail = scannerUpdatdNb.nextInt();

				for (int i = 0; i <= nbEmail; i++) {
					System.out.println("Email : " + i);
					String email = scannerUpdatdMod.nextLine();
					listeEmail.add(email);
				}
				contactUpdate.setEmail(listeEmail);
			}

			// RESEAUX SOCIAUX
			if (up.equalsIgnoreCase("Reseaux Sociaux")) {

				System.out.println("Combien de reseaux Sociaux ? ");
				int nbRS = scannerUpdatdNb.nextInt();
				for (int i = 0; i <= nbRS; i++) {
					System.out.println("Email : " + i);
					String reseauxSociaux = scannerUpdatdMod.nextLine();
					if (estChar(reseauxSociaux)) {
						listeRS.add(reseauxSociaux);
					}
				}
				contactUpdate.setReseauxSociaux(listeRS);
			}

			// PROFESSION
			if (up.equalsIgnoreCase("Profession")) {
				System.out.println("Profession : ");
				String profession = scannerUpdatdMod.nextLine();
				contactUpdate.setProfession(profession);
			}

			// SORTIE MODIFICATION
			if (up.equalsIgnoreCase("Sortie")) {
				System.out.println("Sortie");
			}
		}
		return contactUpdate;
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