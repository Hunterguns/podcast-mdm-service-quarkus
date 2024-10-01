package org.sandeep.service.impl;

import org.sandeep.core.entity.EpisodeEntity;
import org.sandeep.service.EpisodeService;

import java.util.List;

public class EpisodeServiceImpl implements EpisodeService {
    @Override
    public List<EpisodeEntity> getAllEpisodeByPodcastId(String podcastId) {
        return EpisodeEntity.findAllByPodcastId(podcastId);
    }
}
