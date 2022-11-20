package Premier_etape;

import java.util.Arrays;
import java.util.Comparator;

public class Array_user {
	public Contact[] tableauContact;
	Contact acces;

	public Array_user(Contact[] tableauContact) {
		this.tableauContact = tableauContact;
	}

	public int lungTableau() {
		return tableauContact.length;
	}

	// Nom existe?
	public int existeNom(String stringInput) {
		int existe = -1;
		for (int i = 0; i < lungTableau(); i++)
			if (tableauContact[i].getNom().equals(stringInput) == true)
				existe = i;

		if (existe == -1)
			System.out.println("ERREUR: Nom non trouvé");

		return existe;
	}

	// New Contacts vide
	public static Array_user newContactVide() {
		int empty = 0;
		Contact[] nouveauContact = new Contact[empty];
		return new Array_user(nouveauContact);
	}

	public Array_user pop() {
		Contact[] nouveauContact = new Contact[lungTableau()];
		for (int i = 0; i < lungTableau() - 1; i++)
			nouveauContact[i] = tableauContact[i + 1];

		return new Array_user(nouveauContact);
	}

	public Array_user append(Contact newContact) {
		Contact[] nouveauContact = new Contact[lungTableau() + 1];
		nouveauContact[0] = newContact;
		for (int i = 0; i < lungTableau(); i++)
			nouveauContact[i + 1] = tableauContact[i];

		return new Array_user(nouveauContact);
	}

	// Elimine une contact
	public Array_user supprimeContact(int numeroIndice) {
		Array_user resultSupprimeContact = this;

		// Copie de tableauContact vers new tableauContact sans contact numeroIndice
		Contact[] nouveauContact = new Contact[lungTableau() - 1];
		if (lungTableau() == 0) {
			System.out.println("\nERREUR INDICE");

		} else {
			int i = 0;
			while (i < numeroIndice) {
				nouveauContact[i] = tableauContact[i];
				i++;
			}

			i = numeroIndice + 1;

			while (i < lungTableau()) {
				nouveauContact[i - 1] = tableauContact[i];
				i++;
			}

			resultSupprimeContact = new Array_user(nouveauContact);
			System.out.println("Contact: " + tableauContact[numeroIndice].getNom() + " supprimé");
		}

		return resultSupprimeContact;
	}

	// Modification Contact
	public void remplaceContact(Contact modification, int numeroIndice) {
		tableauContact[numeroIndice] = modification;
	}

	public void printContacts() {
		triContact(tableauContact);
		System.out.println("\tGESTIONNAIRE DE CONTACTS:\n");

		if (lungTableau() > 0) {

			for (int i = 0; i < lungTableau(); i++) {
				System.out.println("\tIndice Contact N°: " + i + "\n");
				tableauContact[i].printContact();
			}
		} else
			System.out.println("\tGesionnaire de contacts est vide!\n");

	}

	private static void triContact(Contact[] contacts) {
		Arrays.sort(contacts, new Comparator<Contact>() {
			@Override
			public int compare(Contact new_, Contact old_) {
				var tri = new_.getNom().compareTo(old_.getNom());
				return tri;
			}
		});

	}
}
