package javaPhone;

import java.util.Date;

abstract class Appel {
    static int numberOfAppel = 0;
    int numero;
    Date dateAppel;
    double duree;
    Contact contact;

    // Constructors
    public Appel() {
        this.numero = numberOfAppel;
        numberOfAppel ++;
    }

    public Appel(Date dateAppel, double duree, Contact contact) {
        this.numero = numberOfAppel;
        numberOfAppel ++;
        this.dateAppel = dateAppel;
        this.duree = duree; // en secondes
        this.contact = contact;
    }


    // Methods
    abstract double cout();

    public Contact getContact() {
        return this.contact;
    }

    public Date getDateAppel() {
        return dateAppel;
    }

    public double getDuree() {
        return duree;
    }
}
