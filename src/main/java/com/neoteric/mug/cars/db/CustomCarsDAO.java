package com.neoteric.mug.cars.db;

import com.neoteric.mug.cars.Car;

public interface CustomCarsDAO {

    Car latestWithBrand(String brand);
}
