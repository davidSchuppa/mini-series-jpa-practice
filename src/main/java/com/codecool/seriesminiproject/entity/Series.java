package com.codecool.seriesminiproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {


    @Id
    @GeneratedValue
    private Long id;

    @Singular
    @OneToMany(mappedBy = "series", cascade = CascadeType.PERSIST)
    private List<Season> seasons;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;


}
