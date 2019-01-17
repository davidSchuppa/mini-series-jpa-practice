package com.codecool.seriesminiproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String seasonCode;

    @ManyToOne
    private Series series;

    @Transient
    private Integer numberOfEpisodes;


    @Singular
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<Episode> episodes;


    public Integer calculateNumberOfEpisodes() {
        return episodes.size();
    }
}
