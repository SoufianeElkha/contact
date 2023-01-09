package Troisieme_etape;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Professionnel extends Standard {

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

	// GETTER
	public String getFonction() {
		return fonction;
	}

	// SETTER
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	// PRINT
	@Override
	public String toString() {
		return super.toString() + "\n Fonction: " + "\t" + fonction;
	}
}
