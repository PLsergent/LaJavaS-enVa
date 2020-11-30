package javaPhone;

import java.util.ArrayList;
import java.util.Date;

public interface IAppareil {
    void enregistrer(Contact C);
    void enregistrer(Appel appel, String numTel) throws Exception;
    Contact consulter(int numero);
    ArrayList<Contact> consulter(String mc);
    double couTotal();
    double coutParDate(Date d1, Date d2);
    double coutAppels(int numeroContact);
}
