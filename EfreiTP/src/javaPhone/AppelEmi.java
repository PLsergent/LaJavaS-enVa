package javaPhone;

import java.util.Date;

public class AppelEmi extends Appel {
    // Constructor
    public AppelEmi() {
        super();
    }

    public AppelEmi(Date dateAppel, double duree, Contact contact) {
        super(dateAppel, duree, contact);
    }


    // Methods
    @Override
    double cout() {
        // Cout appel = duree * 2 * 0.5cent
        return this.duree * 2 * 0.05;
    }
}
