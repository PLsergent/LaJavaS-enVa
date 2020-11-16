package collections;

import java.util.Arrays;
import java.util.List;

public class Car {
    static final String[] brands = {"Citroën", "Peugeot", "Renault"};
    static final List<String> carBrands = Arrays.asList(brands);

    static final String[] models = {"Clio", "206", "Laguna", "C1", "C2", "C4", "208", "208 GTI", "508", "Twingo"};
    static final List<String> carModels = Arrays.asList(models);

    static final String[] categories  = {"Citadine", "Routière", "Sportive"};
    static final List<String> carCategories = Arrays.asList(categories);

    String color;
    String brand;
    String model;
    String category;
    Tire tire;

    public Car(String brand, String model, String category) throws Exception {
        this.color = "#Random";

        if (!carBrands.contains(brand))
            throw new Exception("Invalid brand name.");
        this.brand = brand;

        if (!carModels.contains(model))
            throw new Exception("Invalid model.");
        this.model = model;

        if (!carCategories.contains(category))
            throw new Exception("Invalid category.");
        this.category = category;

        if (this.brand.equals("Renault"))
            this.tire = new Tire("Continental");
        else
            this.tire = new Tire("Michelin");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", tire=" + tire +
                '}';
    }
}
