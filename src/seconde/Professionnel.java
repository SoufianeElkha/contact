package seconde;

import java.util.ArrayList;

public class Professionnel extends Contact{
    private String fonction;

    public Professionnel(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone, ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String fonction) {
        super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return super.toString() + "Professionnel{" +
                "fonction='" + fonction + '\'' +
                '}';
    }
}
