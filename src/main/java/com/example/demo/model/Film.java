package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long film_id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Column(name = "release_year", nullable = false, unique = true)
    private String releaseYear;

    @Column(name = "language_id", nullable = false, unique = true)
    private String languageId;

    @Column(name = "original_language_id", nullable = false, unique = true)
    private String originalLanguageId;

    @Column(name = "rental_duration", nullable = false, unique = true)
    private String rentalDuration;

    @Column(name = "rental_rate", nullable = false, unique = true)
    private String rentalRate;

    @Column(name = "length", nullable = false, unique = true)
    private String length;

    @Column(name = "replacement_cost", nullable = false, unique = true)
    private String replacementCost;

    @Column(name = "rating", nullable = false, unique = true)
    private String rating;

    @Column(name = "special_features", nullable = false, unique = true)
    private String specialFeatures;

}