package Troisieme_etape;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

	// path database
	private static String database = "data/database.txt";

	/**
	 * @brief LIRE FICHIER
	 * @param listIn
	 */
	public static void readData(ArrayList<Contact> listIn) {

		boolean endOfFile = false;
		Standard temp;

		try {
			FileInputStream ContactFile = new FileInputStream(database);
			ObjectInputStream contactStream = new ObjectInputStream(ContactFile);
			temp = (Standard) contactStream.readObject();

			while (endOfFile != true) {
				try {
					listIn.add(temp);
					temp = (Standard) contactStream.readObject();
				} catch (EOFException e) {
					endOfFile = true;
				}
			}
			contactStream.close();
		}

		catch (FileNotFoundException e) {
			System.err.println("Class Database : Contact file was not found");
		} catch (IOException e) {
			System.err.println("Class Database : Contact file could not be read");
		} catch (ClassNotFoundException e) {
			System.err.println("Class Database : Contact class was not found");
		}
	}

	/**
	 * @brief ECRIRE DANS UNE FICHIER
	 * @param listOut
	 */
	public static void writeDate(ArrayList<Contact> listOut) {

		try {
			FileOutputStream ContactFile = new FileOutputStream(database);
			ObjectOutputStream ContactStream = new ObjectOutputStream(ContactFile);
			for (Contact c : listOut) {
				ContactStream.writeObject(c);
			}
			ContactStream.close();
		} catch (IOException e) {
			System.out.println("Error occurred while saving");
			e.printStackTrace();
		}
	}

	/**
	 * @brief Save data
	 * @return true si enregistrer
	 */
	@SuppressWarnings("resource")
	public static Boolean save() {

		Scanner scannerSave = new Scanner(System.in);
		try {

			System.out.println("Voulez-vous enregistrer dans database ? [oui/non] [o/n] ");

			String saveString = scannerSave.nextLine();

			if (saveString.equalsIgnoreCase("oui".trim()) || saveString.equalsIgnoreCase("o")) {
				writeDate(User.arrayContact);
				return true;
			} else if (saveString.equalsIgnoreCase("non".trim()) || saveString.equalsIgnoreCase("n")) {
				System.out.println("Enregistrement annulée");
				return false;
			}
		} catch (Exception e) {
			scannerSave.close();
			return false;
		}
		return false;

	}

}
