package com.codecool.seriesminiproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Integer episodeNumber;

    @ManyToOne
    private Season season;

    private LocalDate releaseDate;

    private Integer runTimeInMinutes;

    private String title;



}
