package com.example.githubactionstut.Car.model.Result.model;

import com.example.githubactionstut.Driver.model.Driver;
import com.example.githubactionstut.Season.model.Season;
import com.example.githubactionstut.Team.model.Team;
import com.example.githubactionstut.shared.models.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
@Data
@Getter
@Setter
@AllArgsConstructor
public class Result extends BaseDocument {

    @DocumentReference(lazy=true)
    private Team team;

    @DocumentReference(lazy=true)
    private Driver driver;

    private Integer points;

    private Integer rank;
}
