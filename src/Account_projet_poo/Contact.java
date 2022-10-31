package Account_projet_poo;

import java.util.ArrayList;

public class Contact {

    private String nom;
    private ArrayList<String> prenoms;
    private String adresse;
    private ArrayList<String> telephone;
    private ArrayList<String> email;
    private ArrayList<String> reseauxSociaux;
    private String profession;

    public String getNom() {
        return nom;
    }

    public ArrayList<String> getPrenom() {
        return prenoms = new ArrayList<String>();
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

    public Contact(String nom, ArrayList<String> prenoms, String adresse, ArrayList<String> telephone,
            ArrayList<String> email, ArrayList<String> reseauxSociaux, String profession) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.reseauxSociaux = reseauxSociaux;
        this.profession = profession;
    }

    public static String[] texte = { "Nom:", "Prenom:", "Adresse:", "Telephone:", "E-mail:",
            "Reseau Sociaux:",
            "Profession:" };

    public void printArrayList(ArrayList<String> list, int nbTexte) {
        int i = 1;
        for (String elem : list) {
            System.out.println(texte[nbTexte] + " N°" + i + ": " + elem);
            i++;
        }
    }

    public void printContact() {

        System.out.println(texte[0] + nom);
        printArrayList(prenoms, 1);
        System.out.println(texte[2] + adresse);
        printArrayList(telephone, 3);
        printArrayList(email, 4);
        printArrayList(reseauxSociaux, 5);
        System.out.println(texte[6] + profession + "\n");

    }
}
