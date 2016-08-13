package com.neoteric.mug.cars.db;

import com.neoteric.mug.cars.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public class CarsDAOImpl implements CustomCarsDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Car latestWithBrand(String brand) {
        Query query = new Query()
                .addCriteria(Criteria.where("brand").is(brand))
                .with(new Sort(Sort.Direction.DESC, "id"));

        return mongoTemplate.findOne(query, Car.class);
    }
}
