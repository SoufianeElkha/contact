package Seconde_etape;

import java.util.ArrayList;

public class Amis extends Contact {
	private String signeZodiacal;

	public Amis(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String singeZodiacal) {
		super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
		this.signeZodiacal = singeZodiacal;
	}

	public String getSingeZodiacal() {
		return signeZodiacal;
	}

	public void setSingeZodiacal(String singeZodiacal) {
		this.signeZodiacal = singeZodiacal;
	}

	@Override
	public String toString() {
		return super.toString() + " , signe zodiacal: " + signeZodiacal + '\n';
	}
}
