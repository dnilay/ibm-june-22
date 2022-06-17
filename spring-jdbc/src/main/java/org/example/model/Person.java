package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Person {

    private int personId;
    private String firstName;
    private String lastName;
    private int age;
}
