package com.example.githubactionstut.Driver.model;

import com.example.githubactionstut.shared.models.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Getter
@Setter
@AllArgsConstructor
public class Driver extends BaseDocument {

    private String firstName;

    private String lastName;
}
