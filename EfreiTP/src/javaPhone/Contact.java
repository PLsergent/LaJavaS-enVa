package javaPhone;

public class Contact {
    static int numberOfContact = 0;
    int numero;
    String nom;
    String numeroTel;

    // Constructors
    public Contact() {
        this.numero = numberOfContact;
        numberOfContact++;
    }

    public Contact(String nom, String numeroTel) {
        this.numero = numberOfContact;
        numberOfContact ++;
        this.nom = nom;
        this.numeroTel = numeroTel;
    }


    // Methods
    public int getNumero() {
        return numero;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", numeroTel='" + numeroTel +
                '}';
    }
}
