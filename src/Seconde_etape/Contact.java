package Seconde_etape;

// ALT MAJ S,R
import java.util.ArrayList;

public class Contact {

	private String nom;
	private ArrayList<String> prenom;
	private String adresse;
	private ArrayList<String> telephone;
	private ArrayList<String> email;
	private ArrayList<String> reseauxSociaux;
	private String profession;

	// public Contact() {}

	public Contact(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
			ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession) {
		this.nom = nom;
		this.prenom = prenoms;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.reseauxSociaux = reseauxSociaux;
		this.profession = profession;
	}

	public Contact(String nom, ArrayList<String> prenoms) {
		this.nom = nom;
		this.prenom = prenoms;
	}

	// Getter
	public String getNom() {
		return nom;
	}

	public ArrayList<String> getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public ArrayList<String> getTelephone() {
		return telephone;
	}

	public ArrayList<String> getEmail() {
		return email;
	}

	public ArrayList<String> getReseauxSociaux() {
		return reseauxSociaux;
	}

	public String getProfession() {
		return profession;
	}

	// SETTER
	public void setPrenom(ArrayList<String> prenoms) {
		this.prenom = prenoms;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setTelephone(ArrayList<String> telephone) {
		this.telephone = telephone;
	}

	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	public void setReseauxSociaux(ArrayList<String> reseauxSociaux) {
		this.reseauxSociaux = reseauxSociaux;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public static String[] texte = { "Nom:", "Prenom:", "Adresse:", "Telephone:", "E-mail:", "Reseau Sociaux:",
			"Profession:" };

	public void printArrayList(ArrayList<String> list, int nbTexte) {
		int i = 1;
		for (String elem : list) {
			System.out.println(texte[nbTexte] + " N°" + i + ": " + elem);
			i++;
		}
	}

	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", telephone=" + telephone
				+ ", email=" + email + ", reseauxSociaux=" + reseauxSociaux + ", profession=" + profession + "]";
	}
}