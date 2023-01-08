package Troisieme_etape;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Standard extends Contact {

	/**
	 * @param nom
	 * @param prenoms
	 * @param adresse
	 * @param telephone
	 * @param email
	 * @param reseauxSociaux
	 * @param profession
	 */
	public Standard(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession) {
		super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
	}

	/**
	 * print
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
