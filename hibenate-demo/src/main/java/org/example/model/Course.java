package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "course_table")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "course_id",nullable = false,unique = true)
    private String course_id;
    @Column(name = "course_name",nullable = false,unique = true)
    private String courseName;
    @Column(name = "author_name",nullable = false)
    private String author;
}
