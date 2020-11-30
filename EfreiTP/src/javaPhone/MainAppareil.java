package javaPhone;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainAppareil {
    public static void main(String[] args) throws Exception {
        // Création contacts
        Contact contact1 = new Contact();
        Contact contact2 = new Contact("contact2", "0612345678");
        Contact contact3 = new Contact("contact3", "0623456789");


        // Création appels
        Appel appel1 = new AppelEmi(new Date(2020, Calendar.DECEMBER, 24, 16, 5, 20), 20, contact1);
        Appel appel2 = new AppelRecu(new Date(2020, Calendar.DECEMBER, 25, 16, 5, 20), 40, contact2);
        Appel appel3 = new AppelEmi(new Date(2020, Calendar.DECEMBER, 30, 16, 5, 20), 40, contact3);


        // Création appareil
        Appareil javaPhone = new Appareil();


        // Enregistrement
        // -- Contacts
        javaPhone.enregistrer(contact1);
        javaPhone.enregistrer(contact2);
        javaPhone.enregistrer(contact3);

        // -- Appels
        javaPhone.enregistrer(appel1, "0623479834");
        javaPhone.enregistrer(appel2, "0612345678");
        javaPhone.enregistrer(appel3, "0623456789");

        // Consultation
        // -- par numéro
        System.out.println("=========== Consultation par numéro ===========");
        Contact consultContactNum = javaPhone.consulter(1);
        System.out.println(consultContactNum + "\n");

        // -- par mot clé
        System.out.println("========== Consultation par mot clé ===========");
        ArrayList<Contact> consultContactsMC = javaPhone.consulter("contact");
        System.out.println("Contact commençant par le mot clé contact : ");
        for (Contact c : consultContactsMC) {
            System.out.println(c);
        }

        System.out.println("\n==================== Couts ====================");
        // -- cout total
        System.out.println("Cout total des appels : " + javaPhone.couTotal() + "€\n");

        // -- cout entre deux dates
        System.out.println("Cout total entre le 25 et le 31 décembre : "
                + javaPhone.coutParDate(
                        new Date(2020, Calendar.DECEMBER, 25, 0, 1),
                        new Date(2020, Calendar.DECEMBER, 31, 23, 59)
        ) + "€\n");

        // -- cout concernant un contact
        System.out.println("Cout total pour le contact3 : " + javaPhone.coutAppels(2) + "€");


        // Exceptions : le code ci-dessous renvoit une exception
        // -- car mauvais numéro de téléphone
        // javaPhone.enregistrer(appel2, "00000");

        // -- car un appel est déjà en cours (date)
        // javaPhone.enregistrer(appel3, "0623456789"); ajout du meme appel
    }

}