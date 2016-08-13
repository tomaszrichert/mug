package com.neoteric.mug.cars.db;

import com.neoteric.mug.cars.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarsDAO extends MongoRepository<Car, String> {

}
