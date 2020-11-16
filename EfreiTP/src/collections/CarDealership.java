package collections;

import java.util.ArrayList;

public class CarDealership {
    String address;
    String postalCode;
    String city;
    String carBrand;
    ArrayList<Car> carsInStock;

    public CarDealership(String carBrand) throws Exception {
        if (!Car.carBrands.contains(carBrand))
            throw new Exception("Invalid brand name.");
        this.carBrand = carBrand;
        this.carsInStock = new ArrayList<>();
    }

    public CarDealership(String address, String postalCode, String city, String carBrand) throws Exception {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        if (!Car.carBrands.contains(carBrand))
            throw new Exception("Invalid brand name.");
        this.carBrand = carBrand;
        this.carsInStock = new ArrayList<>();
    }

    public void addCar(Car car) throws Exception {
        if (!this.carBrand.equals(car.getBrand()))
            throw new Exception("Invalid car brand.");
        else
            this.carsInStock.add(car);
    }

    public void displayStock() {
        for (Car car : this.carsInStock) {
            if (this.carsInStock.get(carsInStock.size() - 1) == car)
                System.out.print(car.getModel());
            else
                System.out.print(car.getModel() + ", ");
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return "CarDealership{" +
                "address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carsInStock=" + carsInStock +
                '}';
    }
}
