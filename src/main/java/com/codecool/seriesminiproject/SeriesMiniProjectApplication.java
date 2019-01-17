package com.codecool.seriesminiproject;

import com.codecool.seriesminiproject.entity.Episode;
import com.codecool.seriesminiproject.entity.Genre;
import com.codecool.seriesminiproject.entity.Season;
import com.codecool.seriesminiproject.entity.Series;
import com.codecool.seriesminiproject.repository.EpisodeRepository;
import com.codecool.seriesminiproject.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class SeriesMiniProjectApplication {

    @Autowired
    EpisodeRepository episodeRepository;

    @Autowired
    SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeriesMiniProjectApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Episode vikingsS01E01 = Episode.builder()
                    .episodeNumber(1)
                    .title("Rites of Passage")
                    .releaseDate(LocalDate.of(2013, 3, 4))
                    .runTimeInMinutes(44)
                    .build();

            Episode vikingsS01E02 = Episode.builder()
                    .episodeNumber(2)
                    .title("Wrath of the Norsemen")
                    .releaseDate(LocalDate.of(2013, 3, 11))
                    .runTimeInMinutes(44)
                    .build();

            Episode vikingsS01E03 = Episode.builder()
                    .episodeNumber(3)
                    .title("Dispossessed")
                    .releaseDate(LocalDate.of(2013, 3, 18))
                    .runTimeInMinutes(44)
                    .build();

            Season vikingsS01 = Season.builder()
                    .seasonCode("VikingsS01")
                    .episode(vikingsS01E01)
                    .episode(vikingsS01E02)
                    .episode(vikingsS01E03)
                    .build();

            vikingsS01E01.setSeason(vikingsS01);
            vikingsS01E02.setSeason(vikingsS01);
            vikingsS01E03.setSeason(vikingsS01);

            Series vikings = Series.builder()
                    .genre(Genre.DRAMA)
                    .title("Vikings")
                    .season(vikingsS01)
                    .build();

            vikingsS01.setSeries(vikings);

            seriesRepository.save(vikings);


        };

    }

}

