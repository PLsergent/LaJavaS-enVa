package javaPhone;

import java.util.Date;

public class AppelRecu extends Appel {
    // Constructor
    public AppelRecu() {
        super();
    }

    public AppelRecu(Date dateAppel, double duree, Contact contact) {
        super(dateAppel, duree, contact);
    }


    // Methods
    @Override
    double cout() {
        return 0;
    }
}
