package com.example.githubactionstut.Team.model;

import com.example.githubactionstut.Car.model.Car;
import com.example.githubactionstut.shared.models.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document
@Getter
@Setter
@AllArgsConstructor
public class Team extends BaseDocument {

    @Indexed(unique = true)
    private String name;

    @DocumentReference
    private List<Car> cars;
}
