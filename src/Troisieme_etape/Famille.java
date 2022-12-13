package Troisieme_etape;

import java.util.ArrayList;

public class Famille extends Contact {
	private String lienParent;

	/**
	 * @param nom
	 * @param prenoms
	 * @param adresse
	 * @param telephone
	 * @param email
	 * @param reseauxSociaux
	 * @param profession
	 * @param lienParent
	 */
	public Famille(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String lienParent) {
		super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
		this.lienParent = lienParent;
	}

	/**
	 * @return get Lien Parent
	 */
	public String getLienParent() {
		return lienParent;
	}

	/**
	 * @param lienParent
	 */
	public void setLienParent(String lienParent) {
		this.lienParent = lienParent;
	}

	/**
	 * print Famille
	 */
	@Override
	public String toString() {
		return super.toString() + "\n LienParent: " + "\t" + lienParent;
	}
}
