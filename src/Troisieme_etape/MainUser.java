/// @author Soufiane El kharmoudi
package Troisieme_etape;

import java.io.IOException;
import java.util.Scanner;

public class MainUser {

	/**
	 * @brief MAIN
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		User u = new User();
		u.readData(User.arrayContact);

		Scanner scannerMain = new Scanner(System.in);
		try {
			while (true) {
				// TEXTE MENU
				System.out.print("----------------------------------------------");
				System.out.println(
						"\n\t MENU: 1-2-3-4-5-6-7\nQue voulez-vous faire : \n [1] Insertion d’un nouveau contact \n [2] Affichage des contacts \n [3] Suppression d’un contact"
								+ "\n [4] Modification d’un contact \n [5] Recherche d’un contact  \n [6] Suppression touts les contacts \n [7] Sortie Gestionnaire");
				System.out.print("----------------------------------------------\n");
				String actionString = scannerMain.nextLine();

				// Controle si est une nombre
				if (User.isNumeric(actionString)) {
					// Conversion String to Integer
					int action = Integer.parseInt(actionString);
					// Menu switch
					PetitMenu.menu(action, u);

				} else
					System.out.println("Inserez une nombre entre 1 & 7");

			}
		} catch (Exception e) {
			scannerMain.close();
		}
	}
}