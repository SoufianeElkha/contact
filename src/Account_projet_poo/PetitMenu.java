/*Petit Menu pour utilisateur*/
package Account_projet_poo;

import java.util.ArrayList;
import java.util.Scanner;

public class PetitMenu {

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

	private Boolean ouiScanner(int nbTexte) {
		Scanner ouiScanner = new Scanner(System.in);
		System.out.println("Vous voulez modifier le " + Contact.texte[nbTexte] + "? O/N");
		String oui = ouiScanner.nextLine();

		boolean estOui = false;

		if (oui.equals("o") == true || oui.equals("O") == true)
			estOui = true;
		return estOui;
	}

	// Creation de ArrayList de String pour stocker pluseur
	private static ArrayList<String> prenoms;
	private static ArrayList<String> telephone;
	private static ArrayList<String> email;
	private static ArrayList<String> reseauxSociaux;

	private static ArrayList<String> addInfo(ArrayList<String> info, String texte) {
		Scanner infoScanner = new Scanner(System.in);
		System.out.println("Combien de " + texte + "?");
		String nb = infoScanner.nextLine();

		// Controle si est numerique
		boolean isNumeric = (nb != null && nb.matches("[0-9]+"));
		if (isNumeric == true) {
			int a1 = Integer.parseInt(nb);
			info = new ArrayList<String>();
			for (int i = 0; i < a1; i++) {
				System.out.println(texte + " N° " + (i + 1));
				info.add(infoScanner.nextLine());
			}
		} else {
			System.out.println("ERREUR: Entrez un nombre");
			addInfo(info, texte);
		}
		return info;
	}

	public Array_user putContact(Array_user contacts) {
		Scanner putScanner = new Scanner(System.in);
		System.out.println(Contact.texte[0]);
		String nom = putScanner.nextLine();

		prenoms = addInfo(prenoms, Contact.texte[1]);

		System.out.println(Contact.texte[2]);
		String adresse = putScanner.nextLine();

		telephone = addInfo(telephone, Contact.texte[3]);

		email = addInfo(email, Contact.texte[4]);

		reseauxSociaux = addInfo(reseauxSociaux, Contact.texte[5]);

		System.out.println(Contact.texte[6]);
		String profession = putScanner.nextLine();

		Contact nouveauContact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);

		return contacts.append(nouveauContact);

	}

	public Array_user supprimeContact(Array_user contacts) {
		Scanner supprimeScanner = new Scanner(System.in);
		Array_user newArray = null;

		System.out.println("\nNom à supprimer:");
		String nomIndiceString = supprimeScanner.nextLine();
		int indice = contacts.existeNom(nomIndiceString);

		if (indice >= 0) {
			newArray = contacts.supprimeContact(indice);
		}

		else {
			supprimeContact(contacts);
		}
		return newArray;
	}

	public Array_user modificationContact(Array_user contacts) {

		Scanner modScanner = new Scanner(System.in);

		if (contacts.lungTableau() != 0) {

			int indice;
			System.out.println("Que nom voulez-vous modifier: ");

			String nomIndiceString = modScanner.nextLine();
			indice = contacts.existeNom(nomIndiceString);

			if (indice >= 0) {
				// GETTER
				prenoms = contacts.tableauContact[indice].getPrenom();
				String adresse = contacts.tableauContact[indice].getAdresse();
				telephone = contacts.tableauContact[indice].getTelephone();
				email = contacts.tableauContact[indice].getEmail();
				reseauxSociaux = contacts.tableauContact[indice].getReseauxSociaux();
				String profession = contacts.tableauContact[indice].getProfession();

				// Nom est la cle
				System.out
						.println("Modification contact " + Contact.texte[0] + contacts.tableauContact[indice].getNom());
				String nom = contacts.tableauContact[indice].getNom();

				// if ok, setting new
				if (ouiScanner(1) == true) {
					prenoms = addInfo(prenoms, Contact.texte[1]);
				}

				if (ouiScanner(2) == true) {
					System.out.println(Contact.texte[2]);
					adresse = modScanner.nextLine();
				}

				if (ouiScanner(3) == true) {
					telephone = addInfo(telephone, Contact.texte[3]);
				}

				if (ouiScanner(4) == true) {
					email = addInfo(email, Contact.texte[4]);
				}

				if (ouiScanner(5) == true) {
					reseauxSociaux = addInfo(reseauxSociaux, Contact.texte[5]);
				}

				if (ouiScanner(6) == true) {
					System.out.println(Contact.texte[6]);
					profession = modScanner.nextLine();
				}

				Contact nouveauContact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux,
						profession);
				contacts.remplaceContact(nouveauContact, indice);

			} else {
				modificationContact(contacts);
			}

		} else {
			System.out.println("\tGesionnaire de contacts est vide!\n");
		}
		return contacts;

	}

	public void printContacts(Array_user contacts) {
		contacts.printContacts();

	}

}
