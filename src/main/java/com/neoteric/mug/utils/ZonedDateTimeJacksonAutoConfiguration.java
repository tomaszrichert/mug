package com.neoteric.mug.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ZonedDateTimeJacksonAutoConfiguration {

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"));
    }

    @Bean
    public ObjectMapper objectMapper(DateTimeFormatter dateTimeFormatter) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        SimpleModule module = new JavaTimeModule();
        module.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(dateTimeFormatter));
        mapper.registerModule(module);
        return mapper;
    }
}
