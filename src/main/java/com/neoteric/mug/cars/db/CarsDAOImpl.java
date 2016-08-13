package com.neoteric.mug.cars.db;

import com.neoteric.mug.cars.Car;
import com.neoteric.starter.mongo.request.RequestParamsCriteriaBuilder;
import com.neoteric.starter.request.RequestParameters;
import com.neoteric.starter.request.params.RequestParametersHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public class CarsDAOImpl implements CustomCarsDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RequestParamsCriteriaBuilder requestParamsCriteriaBuilder;

    @Override
    public Car latestWithBrand(String brand) {
        Query query = new Query()
                .addCriteria(Criteria.where("brand").is(brand))
                .with(new Sort(Sort.Direction.DESC, "id"));

        return mongoTemplate.findOne(query, Car.class);
    }

    @Override
    public List<Car> findWithFilters() {
        RequestParameters requestParameters = RequestParametersHolder.get();
        Criteria criteria = requestParamsCriteriaBuilder.build(requestParameters.getFilters());
        Query query = new Query()
                .addCriteria(criteria)
                .skip(requestParameters.getFirst())
                .limit(requestParameters.getPageSize());

        List<Car> cars = mongoTemplate.find(query, Car.class);
        return cars;
    }
}
