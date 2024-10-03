package org.sandeep.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.sandeep.core.entity.EpisodeEntity;
import org.sandeep.model.Episode;
import org.sandeep.service.EpisodeService;

import java.util.List;

@Slf4j
@ApplicationScoped
public class EpisodeServiceImpl implements EpisodeService {
    @Override
    public List<Episode> getAllEpisodeByPodcastId(String podcastId) {
        return EpisodeEntity.findAllByPodcastId(podcastId).stream().map(EpisodeEntity.toEpisode::apply).toList();
    }
}
