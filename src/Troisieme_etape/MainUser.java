/// @author Soufiane El kharmoudi
package Troisieme_etape;

//test
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
		Database.readData(User.arrayContact);

		Scanner scannerMain = new Scanner(System.in);
		try {
			while (true) {
				// TEXTE MENU
				Texte.displayMenu();
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