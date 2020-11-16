package collections;

public class Main {
    public static void main(String[] args) throws Exception {
        // Car dealership
        CarDealership citroen = new CarDealership("Citroën");
        CarDealership peugeot = new CarDealership("Peugeot");
        CarDealership renault = new CarDealership("Renault");

        // Cars
        Car C1 = new Car("Citroën", "C1", "Citadine");
        Car C2 = new Car("Citroën", "C2", "Citadine");
        Car C4 = new Car("Citroën", "C4", "Routière");
        // Add Citroen cars
        citroen.addCar(C1);
        citroen.addCar(C2);
        citroen.addCar(C4);

        Car p208 = new Car("Peugeot", "208", "Citadine");
        Car p208gti = new Car("Peugeot", "208 GTI", "Sportive");
        Car p508 = new Car("Peugeot", "508", "Routière");
        // Add Peugeot cars
        peugeot.addCar(p208);
        peugeot.addCar(p208gti);
        peugeot.addCar(p508);

        Car twingo = new Car("Renault", "Twingo", "Citadine");
        Car clio = new Car("Renault", "Clio", "Citadine");
        Car laguna = new Car("Renault", "Laguna", "Routière");
        renault.addCar(twingo);
        renault.addCar(clio);
        renault.addCar(laguna);

        // Should raise errors
        // > new Car("Unknown brand", "Unknown model", "Unknown category");
        // > new CarDealership("Unknown car brand");
        // > renault.addCar(C1);

        // Display stuff

        System.out.println(citroen);
        citroen.displayStock();

        System.out.println(peugeot);
        peugeot.displayStock();

        System.out.println(renault);
        renault.displayStock();
    }


}
