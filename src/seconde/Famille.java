package seconde;

import java.util.ArrayList;

public class Famille extends Contact{
    private String lienParent;


    public Famille(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone, ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String lienParent) {
        super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
        this.lienParent = lienParent;
    }


    @Override
    public String toString() {
        return super.toString() + "Famille{" +
                "lienParent='" + lienParent + '\'' +
                '}';
    }
}
