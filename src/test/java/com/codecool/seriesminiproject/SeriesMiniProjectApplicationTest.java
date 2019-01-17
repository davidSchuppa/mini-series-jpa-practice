package com.codecool.seriesminiproject;

import com.codecool.seriesminiproject.entity.Episode;
import com.codecool.seriesminiproject.repository.EpisodeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SeriesMiniProjectApplicationTest {

    @Autowired
    EpisodeRepository episodeRepository;

    @Test
    public void saveNewEpisode() {

        Episode episode = Episode.builder()
                .episodeNumber(1)
                .title("Rites of Passage")
                .releaseDate(LocalDate.of(2013, 3, 4))
                .runTimeInMinutes(44)
                .build();

        episodeRepository.save(episode);

        List<Episode> episodes = episodeRepository.findAll();
        assertThat(episodes).hasSize(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void episodeNumberIsNotNull() {

        Episode episode = Episode.builder()
                .title("Wrath")
                .releaseDate(LocalDate.of(2013, 3, 20))
                .runTimeInMinutes(44)
                .build();

        episodeRepository.save(episode);

    }
}