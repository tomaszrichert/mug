package com.neoteric.mug.cars;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = Car.CarBuilder.class)
@Document
public class Car {

    String id;
    String brand;
    String model;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CarBuilder {

        String id;
        String brand;
        String model;
    }
}