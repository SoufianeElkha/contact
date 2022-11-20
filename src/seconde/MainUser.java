package seconde;

import java.util.Scanner;

public class MainUser {

	public static void main(String[] args) {
		User u = new User();
		Scanner scannerMain = new Scanner(System.in);

		while (true) {
			System.out.println(
					"Que voulez-vous faire : \n 1. Insertion d’un nouveau contact \n 2. Affichage des contacts \n 3. Suppression d’un contact"
							+ "\n 4. Modification d’un contact \n 5. Sortie Gestionnaire");

			int action = scannerMain.nextInt();

			if (action == 1) {
				Scanner scannerMain2 = new Scanner(System.in);
				System.out.println(
						"Quel type de contact voulez-vous ajouter ? \n\t- Amis \n\t- Famille \n\t- Professionnel");

				String typeContact = scannerMain2.nextLine();

				if (typeContact.equalsIgnoreCase("amis")) {
					Contact c = User.ajouterContact();
					// SIGNE ZODIAC
					System.out.println("Inserez votre signe zodiaque : ");
					String signeZodiac = scannerMain2.nextLine();

					u.appendAmis(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), signeZodiac);

				} else if (typeContact.equalsIgnoreCase("famille")) {
					Contact c = User.ajouterContact();
					// LIEN PARENT
					System.out.println("Inserez votre lien de parentée : ");
					String lienParent = scannerMain2.nextLine();

					u.appendFamille(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), lienParent);
				} else if (typeContact.equalsIgnoreCase("professionnel")) {
					Contact c = User.ajouterContact();
					// FONCTION
					System.out.println("Inserez votre fonction : ");
					String fonction = scannerMain2.nextLine();

					u.appendProfessionnel(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession(), fonction);
				} else {
					Contact c = User.ajouterContact();
					u.appendContact(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession());

				}
			}

			else if (action == 2) {
				u.stampa();

			} else if (action == 3) {
				Scanner scannerSupprime = new Scanner(System.in);
				System.out.println("Quel nom de contact voulez-vous supprime ? ");

				String nomSupprime = scannerSupprime.nextLine();
				u.remove(nomSupprime);
			}

			else if (action == 4) {

				Scanner scannerUpdateC = new Scanner(System.in);
				System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
				String nomUpdate = scannerUpdateC.nextLine();
				u.updateContact(nomUpdate);
			}

		}
	}

}
