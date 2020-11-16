package collections;

import java.util.Arrays;
import java.util.List;

public class Tire {
    static final String[] tBrands = {"Continental", "Michelin"};
    static final List<String> tireBrands = Arrays.asList(tBrands);

    String brand;
    float width;

    public Tire(String brand) throws Exception {
        if (!tireBrands.contains(brand))
            throw new Exception("Invalid tire brand");
        this.brand = brand;
        this.width = 0;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "brand='" + brand + '\'' +
                ", width=" + width +
                '}';
    }
}
