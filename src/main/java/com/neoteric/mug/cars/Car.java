package com.neoteric.mug.cars;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = Car.CarBuilder.class)
@Document
@CompoundIndexes({@CompoundIndex(name = "brand_model", def = "{ 'brand': 1, 'model': 1}", unique = true)})
public class Car {

    String id;
    String brand;
    String model;
    ZonedDateTime releaseDate;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CarBuilder {

        String id;
        String brand;
        String model;
        ZonedDateTime releaseDate;
    }
}
