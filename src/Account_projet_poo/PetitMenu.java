package Account_projet_poo;

import java.util.ArrayList;
import java.util.Scanner;

public class PetitMenu {

	// Scanner General pour buffer
	public static Scanner scannerUser;

	public PetitMenu() {
		scannerUser = new Scanner(System.in);
	}

	// Creation de ArrayList de String pour stocker pluseur
	private static ArrayList<String> prenoms;
	private static ArrayList<String> telephone;
	private static ArrayList<String> email;
	private static ArrayList<String> reseauxSociaux;

	public static ArrayList<String> addInfo(ArrayList<String> Info, String texte) {
		Scanner nbInfo = new Scanner(System.in);
		System.out.println("Combien de " + texte + "?");
		String a = nbInfo.nextLine();
		// Controle si est numerique
		boolean isNumeric = (a != null && a.matches("[0-9]+"));
		if (isNumeric == true) {
			int a1 = Integer.parseInt(a);
			Info = new ArrayList<String>();
			for (int i = 0; i < a1; i++) {
				System.out.println(texte + " N° " + (i + 1));
				Info.add(scannerUser.nextLine());
			}
		} else {
			System.out.println("ERREUR: Entrez un nombre");
			addInfo(Info, texte);
		}
		return Info;
	}

	public Array_user putContact(Array_user contacts) {

		System.out.println(Contact.texte[0]);
		String nom = scannerUser.nextLine();

		prenoms = addInfo(prenoms, Contact.texte[1]);

		System.out.println(Contact.texte[2]);
		String adresse = scannerUser.nextLine();

		telephone = addInfo(telephone, Contact.texte[3]);

		email = addInfo(email, Contact.texte[4]);

		reseauxSociaux = addInfo(reseauxSociaux, Contact.texte[5]);

		System.out.println(Contact.texte[6]);
		String profession = scannerUser.nextLine();

		Contact nouveauContact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);

		return contacts.append(nouveauContact);

	}

	public Array_user supprimeContact(Array_user contacts) {

		System.out.println("\nNom à supprimer:");
		String nomIndiceString = scannerUser.nextLine();
		int indice = contacts.existeNom(nomIndiceString);
		Array_user newArray = null;
		if (indice >= 0)
			newArray = contacts.supprimeContact(indice);
		else
			supprimeContact(contacts);
		return newArray;
	}

	public Boolean ouiOrNon(int nbTexte) {
		Scanner ouiOrNon = new Scanner(System.in);
		System.out.println("Vous voulez modifier le " + Contact.texte[nbTexte] + "? O/N");
		String ouiOrNonString = ouiOrNon.nextLine();
		boolean a = false;
		if (ouiOrNonString.equals("o") == true || ouiOrNonString.equals("O") == true)
			a = true;

		return a;

	}

	public Array_user modificationContact(Array_user contacts) {
		int indice;

		System.out.println("Nom a modifier: ");

		String nomIndiceString = scannerUser.nextLine();
		indice = contacts.existeNom(nomIndiceString);

		if (indice >= 0) {

			// GETTER
			prenoms = contacts.tableauContact[indice].getPrenom();
			String adresse = contacts.tableauContact[indice].getAdresse();
			telephone = contacts.tableauContact[indice].getTelephone();
			email = contacts.tableauContact[indice].getEmail();
			reseauxSociaux = contacts.tableauContact[indice].getReseauxSociaux();
			String profession = contacts.tableauContact[indice].getProfession();

			// NOM est la cle
			System.out.println("Modification contact " + Contact.texte[0] + contacts.tableauContact[indice].getNom());
			String nom = contacts.tableauContact[indice].getNom();

			// if ok, setting new
			if (ouiOrNon(1) == true) {
				prenoms = addInfo(prenoms, Contact.texte[1]);
			}

			if (ouiOrNon(2) == true) {
				System.out.println(Contact.texte[2]);
				adresse = scannerUser.nextLine();
			}

			if (ouiOrNon(3) == true) {
				telephone = addInfo(telephone, Contact.texte[3]);
			}

			if (ouiOrNon(4) == true) {
				email = addInfo(email, Contact.texte[4]);
			}

			if (ouiOrNon(5) == true) {
				reseauxSociaux = addInfo(reseauxSociaux, Contact.texte[5]);
			}

			if (ouiOrNon(6) == true) {
				System.out.println(Contact.texte[6]);
				profession = scannerUser.nextLine();
			}

			Contact nouveauContact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
			contacts.remplaceContact(nouveauContact, indice);

		} else {
			modificationContact(contacts);
		}
		return contacts;

	}

	public void printContacts(Array_user contacts) {
		contacts.printContacts();

	}

}
