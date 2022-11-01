package Account_projet_poo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Array_user inputString = Array_user.newContactVide();
		PetitMenu petitMenu = new PetitMenu();
		Scanner scanner = new Scanner(System.in);
		String[] textePetitMenu = { "Insertion d’un nouveau contact", "Affichage des contacts",
				"Suppression d’un contact", "Modification d’un contact", "Sortie Gestionnaire" };
		while (true) {
			System.out.println("\t MENU: 1-2-3-4-5");
			int i = 1;
			for (String printMenu : textePetitMenu) {
				System.out.println("[" + i + "]" + printMenu);
				i++;
			}
			int inputChoix = scanner.nextInt();

			switch (inputChoix) {
			case 1:// Insertion d’un nouveau contact
				System.out.println(textePetitMenu[0]);
				inputString = petitMenu.putContact(inputString);
				break;
			case 2:// Affichage des contacts
				System.out.println(textePetitMenu[1]);
				petitMenu.printContacts(inputString);
				break;
			case 3:// Suppression d’un contact
				System.out.println(textePetitMenu[2]);
				inputString = petitMenu.supprimeContact(inputString);
				break;
			case 4:// Modification d’un contact
				System.out.println(textePetitMenu[3]);
				inputString = petitMenu.modificationContact(inputString);
				break;
			case 5:// Sortie de Gestionnaire
				System.out.println(textePetitMenu[4]);
				scanner.close();
				System.exit(0);
				break;
			}

		}

	}

}
