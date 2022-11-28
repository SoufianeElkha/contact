package Seconde_etape;

import java.util.ArrayList;

public class Professionnel extends Contact {
	private String fonction;

	/**
	 * @param nom
	 * @param prenoms
	 * @param adresse
	 * @param telephone
	 * @param email
	 * @param reseauxSociaux
	 * @param profession
	 * @param fonction
	 */
	public Professionnel(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String fonction) {
		super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
		this.fonction = fonction;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * print
	 */
	@Override
	public String toString() {
		return super.toString() + "\n Fonction: " + "\t" + fonction + "\n----------------------------------------\n";
	}
}
