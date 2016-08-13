package com.neoteric.mug.cars.db;

import com.neoteric.mug.cars.Car;

import java.util.List;

public interface CustomCarsDAO {

    List<Car> findWithFilters();

    Car latestWithBrand(String brand);
}
