package Account_projet_poo;

import java.util.ArrayList;

public class Array_user {
    public Contact[] tableauContact;

    public Array_user(Contact[] tableauContact) {
        this.tableauContact = tableauContact;
    }

    public int lungTableau() {
        return tableauContact.length;

    }

    // Retourn le premier element de la liste
    public Contact tete() {
        return tableauContact[0];
    }

    public static void tableauContactInfo(ArrayList<String> list, int nb) {
        list = new ArrayList<String>(nb);
    }

    // Nwe Contacts vide
    public static Array_user newContactVide() {
        int empty = 0;
        Contact[] nouveauContact = new Contact[empty];
        return new Array_user(nouveauContact);
    }

    public Array_user pop() {
        Contact[] nouveauContact = new Contact[lungTableau()];
        for (int i = 0; i < lungTableau() - 1; i++) {
            nouveauContact[i] = tableauContact[i + 1];
        }
        return new Array_user(nouveauContact);
    }

    public Array_user append(Contact value) {
        Contact[] nouveauContact = new Contact[lungTableau() + 1];
        nouveauContact[0] = value;
        for (int i = 0; i < lungTableau(); i++) {
            nouveauContact[i + 1] = tableauContact[i];
        }
        return new Array_user(nouveauContact);
    }

    public void printContacts() {
        int lung = lungTableau();
        System.out.println("\tGESTIONNAIRE DE CONTACTS:\n");
        if (lung > 0) {
            for (int i = 0; i < lung; i++) {
                int indice = i;
                System.out.println("\tIndice Contact N°: " + indice + "\n");
                tableauContact[i].printContact();
            }
        } else {
            System.out.println("\tGesionnaire de contacts est vide!\n");
        }
    }

    public Array_user supprimeContact(int numeroIndice) {
        Array_user resultSupprimeContact = this;
        // Copie de tableauContact vers new tableauContact sans contact numeroIndice
        Contact[] nouveauContact = new Contact[lungTableau() - 1];
        if (numeroIndice >= 0) {
            for (int i = 0; i < numeroIndice; i++) {
                nouveauContact[i] = tableauContact[i];
            }
            for (int i = numeroIndice + 1; i < lungTableau(); i++) {
                nouveauContact[i - 1] = tableauContact[i];
            }
            resultSupprimeContact = new Array_user(nouveauContact);
        } else {
            System.out.println("\nERROR INDICE");
        }
        return resultSupprimeContact;
    }

    public Array_user modificationContact(int numeroIndice) {
        Array_user resultModificationContact = this;
        // Copie de tableauContact vers new tableauContact sans contact numeroIndice
        Contact[] nouveauContact = new Contact[lungTableau() - 1];
        if (numeroIndice >= 0) {
            for (int i = 0; i < numeroIndice; i++) {
                nouveauContact[i] = tableauContact[i];
            }
            for (int i = numeroIndice + 1; i < lungTableau(); i++) {
                nouveauContact[i - 1] = tableauContact[i];
            }
            resultModificationContact = new Array_user(nouveauContact);
        } else {
            System.out.println("\nERROR INDICE");
        }
        return resultModificationContact;
    }

}
