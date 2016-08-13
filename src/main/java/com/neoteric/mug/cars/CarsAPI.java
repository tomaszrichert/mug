package com.neoteric.mug.cars;

import com.neoteric.mug.cars.db.CarsDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarsAPI {

    private final CarsDAO carsDAO;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> get() {
        return carsDAO.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Car create(@RequestBody Car car) {
        return carsDAO.save(car);
    }

}
