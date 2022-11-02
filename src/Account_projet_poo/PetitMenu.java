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

	public Array_user modificationContact(Array_user contacts) {

		System.out.println("\nIndice du contact:");
		int indice = scannerUser.nextInt();

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

		contacts.remplaceContact(nouveauContact, indice);
		return contacts;

	}

}
