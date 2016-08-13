package com.neoteric.mug.cars.db;

import com.neoteric.mug.cars.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface CarsDAO extends MongoRepository<Car, String>, CustomCarsDAO {

    Optional<Car> findOneByBrand(String brand);

    List<Car> findByBrand(String brand);

    Stream<Car> findByBrandStartsWith(String brand);

    @Query(value = "{ 'brand' : ?0 }", fields = "{ 'brand' : 1 }")
    List<Car> findByCarBrand(String brand);

    @Async
    Future<List<Car>> findByBrandNot(String brand);
}
