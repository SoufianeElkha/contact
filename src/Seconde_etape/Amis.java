package Seconde_etape;

import java.util.ArrayList;

public class Amis extends Contact {
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

	public String getSigneZodiacal() {
		return signeZodiacal;
	}

	public void setSingeZodiacal(String singeZodiacal) {
		this.signeZodiacal = singeZodiacal;
	}

	/**
	 * print
	 */
	@Override
	public String toString() {
		return super.toString() + "\n Signe zodiacal: " + signeZodiacal
				+ "\n----------------------------------------\n";
	}
}
