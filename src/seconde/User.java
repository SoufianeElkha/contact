package seconde;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public ArrayList<Contact> arrayContact = new ArrayList<>();

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
			System.out.println("Prenom : " + i);
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
			listeTelephone.add(telephone);
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

	public void stampa() {

		for (Contact c : arrayContact) {
			System.out.println("\n" + c + "\n");
		}

	}

	public void remove(String nom) {

		int indice = 0;
		for (Contact c : arrayContact) {
			if (c.getNom().equals(nom)) {
				indice = arrayContact.indexOf(c);
			}
		}
		arrayContact.remove(indice);
	}

	public void updateContact(String nom) {
		ArrayList<String> listePrenom = new ArrayList<>();

		int index = 0;
		Contact contactUpdate = null;
		for (Contact c : arrayContact) {
			if (c.getNom().equals(nom)) {
				index = arrayContact.indexOf(c);
				contactUpdate = arrayContact.get(index);
				break;
			}
		}
		Scanner scannerUpdatd = new Scanner(System.in);
		System.out.println(
				"Quel champ voulez-vous modifier ? \nPrenom \nAdresse \nTéléphone \nEmail \nReseaux Sociaux \nProfession ");
		String up = scannerUpdatd.nextLine();

		if (up.equalsIgnoreCase("prenom")) {
			Scanner scannerUpdatdNb = new Scanner(System.in);
			System.out.println("Combien de prenom ? ");
			int nbPrenom = scannerUpdatdNb.nextInt();

			for (int i = 0; i <= nbPrenom; i++) {
				Scanner scannerUpdatdPre = new Scanner(System.in);
				System.out.println("Prenom : " + i);
				String prenom = scannerUpdatdPre.nextLine();
				listePrenom.add(prenom);
			}
			contactUpdate.setPrenom(listePrenom);
		}
	}

	// Contrôle si est un caractère alphabétique
	public boolean estChar(String s) {
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
