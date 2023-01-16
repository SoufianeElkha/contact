package Troisieme_etape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {

	/**
	 * @brief PREMIER CARACTERE MAJUSCULE
	 * @param string
	 * @return string avec premier lettre de la string en majuscule
	 */
	public static String firstCharUpperCase(String s) {
		if (!s.equals(null))
			s = s.substring(0, 1).toUpperCase() + s.substring(1);
		return s;
	}

	/**
	 * @brief orderContact GESTIONNAIRE
	 */
	static void orderContact() {

		Contact sort;
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
	 * @param nom : nom a cherche
	 * @return true or false
	 */
	public static boolean existContact(String nom) {

		try {
			return User.arrayContact.stream().anyMatch(c -> c.getNom().toUpperCase().equals(nom.toUpperCase()));
		} catch (Exception e) {
			return false;
		}
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
				System.err.println("ERROR: Gestionnaire Vide");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/*
	 * @brief Scanner Generaux
	 * 
	 * @return String input
	 */
	public static String scan() {
		String input = null;
		Scanner scanner = new Scanner(System.in);
		try {
			input = scanner.nextLine();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			scanner.close();
			scan();
		}
		return input;
	}

}
