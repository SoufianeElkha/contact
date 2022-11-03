//# Soufiane El kharmoudi
//# Projet POO 2022

/*
 * Vous devez modéliser la notion de contact. Un contact à un nom, un ou
 * plusieurs prénoms, une adresse, un ou plusieurs numéros de téléphone, une ou
 * plusieurs adresses mail, un compte sur un ou plusieurs réseaux sociaux, et
 * une profession. Vous devez stocker les contacts dans un tableau toujours
 * triés. 
 * Vous devez faire un petit menu permettant à l’utilisateur
 * 
 * d’avoir les fonctionnalités suivantes : 
 * • Insertion d’un nouveau contact 
 * •Modification et suppression d’un contact 
 * • Affichage des contacts
 */

package Account_projet_poo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Array_user inputString = Array_user.newContactVide();
		PetitMenu petitMenu = new PetitMenu();

		while (true) {

			String[] textePetitMenu = { "Insertion d’un nouveau contact", "Affichage des contacts",
					"Suppression d’un contact", "Modification d’un contact", "Sortie Gestionnaire" };

			System.out.println("\t MENU: 1-2-3-4-5");
			int i = 1;
			for (String printMenu : textePetitMenu) {
				System.out.println("[" + i + "]" + printMenu);
				i++;
			}

			String inputChoix = scanner.nextLine();

			if (petitMenu.estChar(inputChoix) == false) {

				int inputNbChoix = Integer.parseInt(inputChoix);

				if (inputNbChoix > 0 && inputNbChoix < 6) {

					switch (inputNbChoix) {

					// Insertion d’un nouveau contact
					case 1:
						System.out.println(textePetitMenu[0]);
						inputString = petitMenu.putContact(inputString);
						break;
					// Affichage des contacts
					case 2:
						System.out.println(textePetitMenu[1]);
						petitMenu.printContacts(inputString);
						break;
					// Suppression d’un contact
					case 3:
						System.out.println(textePetitMenu[2]);
						inputString = petitMenu.supprimeContact(inputString);
						break;
					// Modification d’un contact
					case 4:
						System.out.println(textePetitMenu[3]);
						inputString = petitMenu.modificationContact(inputString);
						break;
					// Sortie de Gestionnaire
					case 5:
						System.out.println(textePetitMenu[4]);
						scanner.close();
						System.exit(0);
						break;
					}
				} else {
					System.out.println("ERREUR: Entrez un nombre compris entre 1 et 5");
				}
			} else {
				System.out.println("ERREUR: Entrez un nombre");
			}
		}
	}
}
