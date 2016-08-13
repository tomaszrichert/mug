package com.neoteric.mug.cars;

import com.neoteric.mug.cars.db.CarsDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarsAPI {

    private final CarsDAO carsDAO;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> get() {
        return carsDAO.findWithFilters();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Car create(@RequestBody Car car) {
        return carsDAO.save(car);
    }

    /* Query methods */

    @RequestMapping(value = "/{brand}", method = RequestMethod.GET)
    public List<Car> getByBrand(@PathVariable("brand") String brand) {
        return carsDAO.findByCarBrand(brand);
    }

    /* Custom repository */

    @RequestMapping(value = "/{brand}/latest", method = RequestMethod.GET)
    public Car latest(@PathVariable("brand") String brand) {
        return carsDAO.latestWithBrand(brand);
    }

}
