package Account_projet_poo;

import java.util.ArrayList;
import java.util.Scanner;

public class PetitMenu {
    public static Scanner scannerUser;

    public PetitMenu() {
        scannerUser = new Scanner(System.in);

    }

    // Creation de ArrayList de String pour stocker pluseur
    private static ArrayList<String> prenoms;
    private static ArrayList<String> telephone;
    private static ArrayList<String> email;
    private static ArrayList<String> reseauxSociaux;

    public static ArrayList<String> addInfo(ArrayList<String> Info, String texte) {
        Scanner nbInfo = new Scanner(System.in);
        System.out.println("Combien de " + texte + "?");
        int a = nbInfo.nextInt();
        Info = new ArrayList<String>(a);
        for (int i = 0; i < a; i++) {
            System.out.println(texte + " N° " + (i + 1));
            Info.add(scannerUser.nextLine());
        }
        return Info;
    }

    public Array_user putContact(Array_user contacts) {

        System.out.println(Contact.texte[0]);
        String nom = scannerUser.nextLine();

        prenoms = addInfo(prenoms, Contact.texte[1]);

        System.out.println(Contact.texte[2]);
        String adresse = scannerUser.nextLine();

        telephone = addInfo(telephone, Contact.texte[3]);

        email = addInfo(email, Contact.texte[4]);

        reseauxSociaux = addInfo(reseauxSociaux, Contact.texte[5]);

        System.out.println(Contact.texte[6]);
        String profession = scannerUser.nextLine();

        Contact nouveauContact = new Contact(nom, prenoms, adresse, telephone, email, reseauxSociaux,
                profession);

        return contacts.append(nouveauContact);

    }

    public Array_user supprimeContact(Array_user contacts) {
        System.out.println("\nIndice du contact à supprimer:");
        int indice = scannerUser.nextInt();
        return contacts.supprimeContact(indice);
    }

    public void printContacts(Array_user contacts) {
        contacts.printContacts();

    }

}
