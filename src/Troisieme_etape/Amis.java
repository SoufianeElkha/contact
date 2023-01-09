package Troisieme_etape;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Amis extends Standard {
	private String signeZodiacal;

	/**
	 * @param nom
	 * @param prenoms
	 * @param adresse
	 * @param telephone
	 * @param email
	 * @param reseauxSociaux
	 * @param profession
	 * @param singeZodiacal
	 */
	public Amis(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String singeZodiacal) {
		super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
		this.signeZodiacal = singeZodiacal;
	}

	// GETTER
	public String getSigneZodiacal() {
		return signeZodiacal;
	}

	// SETTER
	public void setSingeZodiacal(String singeZodiacal) {
		this.signeZodiacal = singeZodiacal;
	}

	// Print
	@Override
	public String toString() {
		return super.toString() + "\n Signe zodiacal: " + signeZodiacal;
	}
}
