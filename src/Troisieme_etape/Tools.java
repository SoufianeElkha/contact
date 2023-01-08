package Troisieme_etape;

import java.util.Scanner;

public class Tools {

	/**
	 * 
	 * @brief PREMIER CARACTERE MAJUSCULE
	 * @param string
	 * @return string avec premier lettre en majuscule
	 */
	public static String firstCharUpperCase(String string) {
		if (string.equals(null))
			string = string.substring(0, 1).toUpperCase() + string.substring(1);
		return string;

	}

	/**
	 * @brief orderContact GESTIONNAIRE
	 */
	static void orderContact() {

		Standard sort;
		for (int i = 0; i < User.arrayContact.size() - 1; i++) {
			for (int j = i + 1; j < User.arrayContact.size(); j++) {
				// COMPARE ELEMENT
				if (User.arrayContact.get(i).getNom().toUpperCase()
						.compareTo(User.arrayContact.get(j).getNom().toUpperCase()) >= 0) {
					// orderContact
					sort = User.arrayContact.get(i);
					User.arrayContact.set(i, User.arrayContact.get(j));
					User.arrayContact.set(j, sort);
				}
			}
		}
		Database.writeDate(User.arrayContact);
	}

	/**
	 * @brief AFFICHAGE
	 */
	public static void displayContact() {
		orderContact();
		User.arrayContact.forEach(System.out::println);
	}

	/**
	 * @brief RECHERCHE NOM SI existContact
	 * @param nom nom a cherche
	 * @return true or false
	 */
	public static boolean existContact(String nom) {

		try {
			for (Standard c : User.arrayContact)
				if (c.getNom().equals(nom))
					return true;
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	/**
	 * @brief VERIFICATION SI EST NOMBRE
	 * @param s
	 * @return true si est une nombre
	 */
	public static boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @brief VERIFICATION SI GESTIONNAIRE EST VIDE
	 * @return true si gestionnaire est vide
	 */
	public static boolean isEmpty() {
		try {
			if (User.arrayContact.isEmpty()) {
				System.out.println("ERROR: Gestionnaire Vide");
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;

	}

	public static String scan() {
		String input = null;
		Scanner scanner = new Scanner(System.in);
		try {
			input = scanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			scanner.close();
			scan();
		}
		return input;
	}

}
