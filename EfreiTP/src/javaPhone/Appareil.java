package javaPhone;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Appareil implements IAppareil {
    ArrayList<Contact> contacts;
    // On stocke les appels sous forme d'une  liste de "paire" : (appel, numTel)
    ArrayList<Pair<Appel, String>> appels;

    // Constructor
    public Appareil() {
        this.contacts = new ArrayList<>();
        this.appels = new ArrayList<>();
    }


    @Override
    public void enregistrer(Contact C) {
        contacts.add(C);
    }

    @Override
    public void enregistrer(Appel appel, String numTel) throws Exception {
        Pair<Appel, String> infoAppel = new Pair<>(appel, numTel);
        if (appel.getContact().getNumeroTel() == null)
            appels.add(infoAppel);
        else if (appel.getContact().getNumeroTel().equals(numTel))
            if (checkAppel(appel))
                appels.add(infoAppel);
            else
                throw new Exception("Erreur : il y a déjà un appel en cours.");
        else
            throw new Exception("Erreur : le numéro de téléphone ne correspond pas à celui du contact de l'appel.");
    }

    // On part du principe que le dernier appel enregistrer est le plus vieux
    // Autrement dit que l'arraylist "appels" est triée par ordre chronologique
    // Ici on vérifie que le nouvel appel ne commence pas avant la fin du dernier appel enregistré
    private boolean checkAppel(Appel newAppel) {
        Pair<Appel, String> infoLastAppel = appels.get(appels.size() - 1);
        Appel lastAppel = infoLastAppel.getLeft();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastAppel.getDateAppel());
        calendar.add(Calendar.SECOND, (int) lastAppel.getDuree());
        return newAppel.getDateAppel().after(calendar.getTime());
    }

    @Override
    public Contact consulter(int numero) {
        for (Contact c : contacts) {
            if (c.getNumero() == numero)
                return c;
        }
        System.out.println("Il n'existe pas de contact à ce numéro.");
        return null;
    }

    @Override
    public ArrayList<Contact> consulter(String mc) {
        ArrayList<Contact> returnedContact = new ArrayList<>();

        for (Contact c : contacts) {
            if (c.getNom() != null)
                if (c.getNom().startsWith(mc))
                    returnedContact.add(c);
        }

        if (returnedContact.size() == 0)
            System.out.println("Pas de contacts commençant par le mot clé : " + mc);

        return returnedContact;
    }

    @Override
    public double couTotal() {
        double couTotal = 0;
        for (Pair<Appel, String> tupleAppel : appels) {
            Appel appel = tupleAppel.getLeft();
            couTotal += appel.cout();
        }
        return couTotal;
    }

    @Override
    // d1 is before d2
    public double coutParDate(Date d1, Date d2) {
        double coutParDate = 0;
        // Check if d1 is before d2
        if (d1.before(d2)) {
            for (Pair<Appel, String> tupleAppel : appels) {
                Appel appel = tupleAppel.getLeft();
                if (appel.getDateAppel().after(d1) && appel.getDateAppel().before(d2)) {
                    coutParDate += appel.cout();
                }
            }
        }
        return coutParDate;
    }

    @Override
    public double coutAppels(int numeroContact) {
        double coutAppels = 0;
        for (Pair<Appel, String> tupleAppel : appels) {
            Appel appel = tupleAppel.getLeft();
            if (appel.getContact().getNumero() == numeroContact)
                coutAppels += appel.cout();
        }
        return coutAppels;
    }
}
