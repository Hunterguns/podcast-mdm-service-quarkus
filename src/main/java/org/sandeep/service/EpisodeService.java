package org.sandeep.service;

import org.sandeep.core.entity.EpisodeEntity;

import java.util.List;

public interface EpisodeService {

    List<EpisodeEntity> getAllEpisodeByPodcastId(String podcastId);
}
