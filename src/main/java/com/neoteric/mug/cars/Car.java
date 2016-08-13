package com.neoteric.mug.cars;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = Car.CarBuilder.class)
@Document
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
