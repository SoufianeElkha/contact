//@ Soufiane El kharmoudi
package Seconde_etape;

import java.util.Scanner;

public class MainUser {

	public static void main(String[] args) {
		User u = new User();
		Scanner scannerMain = new Scanner(System.in);

		while (true) {
			// TEXTE MENU
			System.out.print("----------------------------------------------");
			System.out.println(
					"\n\t MENU: 1-2-3-4-5-6-7\nQue voulez-vous faire : \n [1] Insertion d’un nouveau contact \n [2] Affichage des contacts \n [3] Suppression d’un contact"
							+ "\n [4] Modification d’un contact \n [5] Recherche d’un contact  \n [6] Suppression touts les contacts \n [7] Sortie Gestionnaire");

			String actionString = scannerMain.nextLine();

			// Controle si est une nombre
			boolean estNb = (actionString != null && actionString.matches("[0-9]+"));
			if (estNb) {
				// Conversion String to Integer
				int action = Integer.parseInt(actionString);
				// Menu switch
				PetitMenu.menu(action, u);
			} else {
				System.out.println("Inserez une nombre entre 1 & 7");
			}
		}
	}
}