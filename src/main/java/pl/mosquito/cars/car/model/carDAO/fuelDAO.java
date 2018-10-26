package pl.mosquito.cars.car.model.carDAO;

import java.util.ArrayList;
import java.util.List;

public class fuelDAO {
    private static final List<String> FUELS = new ArrayList<>();

    fuelDAO(){
        FUELS.add("Petrol");
        FUELS.add("Diesel");
        FUELS.add("LPG");
        FUELS.add("Electric");
    }


    public List<String>getFuels() {
        return FUELS;
    }

}
