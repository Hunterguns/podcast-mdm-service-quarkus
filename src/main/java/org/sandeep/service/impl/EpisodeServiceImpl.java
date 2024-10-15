package org.sandeep.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.sandeep.core.entity.EpisodeEntity;
import org.sandeep.model.Episode;
import org.sandeep.model.requests.EpisodeRequest;
import org.sandeep.service.EpisodeService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@ApplicationScoped
public class EpisodeServiceImpl implements EpisodeService {
    @Override
    public List<Episode> getAllEpisodeByPodcastId(String podcastId) {
        return EpisodeEntity.findAllByPodcastId(podcastId).stream().map(EpisodeEntity.toEpisode::apply).toList();
    }

    @Override
    @Transactional
    public Episode createEpisode(EpisodeRequest episodeRequest) {        //TODO: Take duration as time or string, convert and store accordingly in the db
        Duration parse = Duration.parse(episodeRequest.getDuration());
        EpisodeEntity episodeEntity = EpisodeRequest.toEpisodeEntity.apply(episodeRequest);
        episodeEntity.setPublishDate(LocalDate.now());
        EpisodeEntity.persist(episodeEntity);
        return EpisodeEntity.toEpisode.apply(episodeEntity);
    }
}
