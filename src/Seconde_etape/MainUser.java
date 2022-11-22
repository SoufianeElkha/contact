package Seconde_etape;

import java.util.Scanner;

public class MainUser {

	public static void main(String[] args) {
		User u = new User();
		Scanner scannerMain = new Scanner(System.in);

		while (true) {
			System.out.println(
					"Que voulez-vous faire : \n 1. Insertion d’un nouveau contact \n 2. Affichage des contacts \n 3. Suppression d’un contact"
							+ "\n 4. Modification d’un contact \n 5. Recherche d’un contact  \n 6. Suppression touts les contacts \n 7. Sortie Gestionnaire");

			int action = scannerMain.nextInt();
			switch (action) {

//Insertion d’un nouveau contact
			case 1:

				Scanner scannerMain2 = new Scanner(System.in);
				System.out.println(
						"Quel type de contact voulez-vous ajouter ? \n\t- Standard \n\t- Amis \n\t- Famille \n\t- Professionnel");

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
				} else if (typeContact.equalsIgnoreCase("standard")) {
					Contact c = User.ajouterContact();
					u.appendContact(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(),
							c.getReseauxSociaux(), c.getProfession());
				} else {
					System.out.println("Inserez le type correct!\n");
				}

				break;
//Affichage des contacts
			case 2:
				u.printContact();

				break;
//Suppression d’un contact
			case 3:

				Scanner scannerSupprime = new Scanner(System.in);
				System.out.println("Quel nom de contact voulez-vous supprime ? ");

				String nomSupprime = scannerSupprime.nextLine();
				u.supprimeContact(nomSupprime);

				break;
//Modification d’un contact
			case 4:

				Scanner scannerUpdateC = new Scanner(System.in);
				System.out.println("Quel contact voulez-vous modifier ? : Entrez le nom :");
				String nomUpdate = scannerUpdateC.nextLine();
				u.modificationContact(nomUpdate);

				break;
//Recherche d’un contact
			case 5:

				Scanner scannerRecherche = new Scanner(System.in);
				Scanner scannerRechercheType = new Scanner(System.in);

				System.out.println("\nRecherche d'un contact\n");
				System.out.println(
						"\nVoulez-vous faire une recherche par?: \n Nom \n Prenom \n Adresse \n Telephone \n E-mail \n Reseau Sociaux \n Profession:");
				String typeRecherche = scannerRecherche.nextLine();
				System.out.println("Quel contact voulez-vous recherche ? ");
				String nomFind = scannerRechercheType.nextLine();
				u.rechercheContact(typeRecherche, nomFind);

				break;
//Suppression touts les contacts
			case 6:

				Scanner scannerSupprime1 = new Scanner(System.in);
				System.out.println("Voulez-vous supprime touts la liste ? oui/non ");

				String allSupprime = scannerSupprime1.nextLine();

				if (allSupprime.equalsIgnoreCase("oui")) {
					u.supprimeAllContact(allSupprime);
				} else if (allSupprime.equalsIgnoreCase("non")) {
					System.out.println("Commande annulé");
					continue;
				}

				break;
//Sortie Gestionnaire
			case 7:
				System.out.println("Sortie Gestionnaire");
				System.exit(0);

			}

		}
	}

}