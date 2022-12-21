package com.example.githubactionstut.Car.model;

import com.example.githubactionstut.Driver.model.Driver;
import com.example.githubactionstut.shared.models.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
import java.util.Objects;

@Data
@Document
@Getter
@Setter
@AllArgsConstructor
public class Car extends BaseDocument {

    private Integer horsepower;

    private String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return horsepower.equals(car.horsepower) && model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsepower, model);
    }
}
