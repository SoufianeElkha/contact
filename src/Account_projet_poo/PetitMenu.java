package Account_projet_poo;

import java.util.ArrayList;
import java.util.Scanner;

public class PetitMenu {
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
			Info = new ArrayList<String>(a1);
			for (int i = 0; i < a1; i++) {
				System.out.println(texte + " N° " + (i + 1));
				Info.add(scannerUser.nextLine());
			}
		} else {
			System.out.println("Error: Entree number!");
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
		System.out.println("\nIndice du contact à supprimer:");
		int indice = scannerUser.nextInt();
		return contacts.supprimeContact(indice);
	}

	public void printContacts(Array_user contacts) {
		contacts.printContacts();

	}

	public Boolean ouiOrNon() {
		Scanner ouiOrNon = new Scanner(System.in);
		System.out.println("Vous voulez modifier le " + Contact.texte[1] + "? O/N");
		String ouiOrNonString = ouiOrNon.nextLine();
		boolean a = false;
		if (ouiOrNonString.equals("o") == true || ouiOrNonString.equals("O") == true)
			a = true;
		if (ouiOrNonString.equals("n") == true || ouiOrNonString.equals("N") == true)
			a = false;
		return a;

	}

	public Array_user modificationContact(Array_user contacts) {
		int indice;
		System.out.println("Nom a modifier:");
		String nomIndiceString = scannerUser.nextLine();
		indice = contacts.findString(nomIndiceString);

		System.out.println("Modification contact " + Contact.texte[0] + contacts.tableauContact[indice].getNom());
		String nom = contacts.tableauContact[indice].getNom();

		if (ouiOrNon() == true) {
			prenoms = addInfo(prenoms, Contact.texte[1]);
		} else if (ouiOrNon() == false) {
			prenoms = contacts.tableauContact[indice].getPrenom();
		}

		if (ouiOrNon() == true) {
			String adresse = scannerUser.nextLine();
		} else if (ouiOrNon() == false) {
			String adresse = contacts.tableauContact[indice].getAdresse();
		}
		if (ouiOrNon() == true) {
			telephone = addInfo(telephone, Contact.texte[3]);
		} else if (ouiOrNon() == false) {
			telephone = contacts.tableauContact[indice].getTelephone();
		}

		if (ouiOrNon() == true) {

			email = addInfo(email, Contact.texte[4]);
		} else if (ouiOrNon() == false) {
			email = contacts.tableauContact[indice].getEmail();

		}

		reseauxSociaux = addInfo(reseauxSociaux, Contact.texte[5]);

		System.out.println(Contact.texte[6]);
		String profession = scannerUser.nextLine();

		Contact nouveauContact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);

		contacts.remplaceContact(nouveauContact, indice);
		return contacts;

	}

}
