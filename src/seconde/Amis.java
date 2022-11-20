package seconde;

import java.util.ArrayList;

public class Amis extends Contact{
    private String singeZodiacal;

    public Amis(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone, ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession, String singeZodiacal) {
        super(nom, prenoms, adresse, telephone, email, reseauxSociaux, profession);
        this.singeZodiacal = singeZodiacal;
    }


    public String getSingeZodiacal() {
        return singeZodiacal;
    }

    public void setSingeZodiacal(String singeZodiacal) {
        this.singeZodiacal = singeZodiacal;
    }


    @Override
    public String toString() {
        return super.toString() + "Amis{" +
                "singeZodiacal='" + singeZodiacal + '\'' +
                '}';
    }
}
