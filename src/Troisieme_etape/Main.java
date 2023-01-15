/// @author Soufiane El kharmoudi
package Troisieme_etape;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		User u = new User();
		Database.readData(User.arrayContact);
		String actionString;
		int action;
		while (true) {
			// TEXTE MENU
			Texte.displayMenu();
			actionString = Tools.scan();

			// Controle si est une nombre
			if (Tools.isNumeric(actionString) && actionString != null) {
				// Conversion String to Integer
				action = Integer.parseInt(actionString);
				// Menu switch
				PetitMenu.menu(action, u);

			} else
				System.out.println("Inserez une nombre entre 1 & 7");
		}
	}
}