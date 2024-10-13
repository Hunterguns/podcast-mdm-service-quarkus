package org.sandeep.service;

import jakarta.transaction.Transactional;
import org.sandeep.core.entity.EpisodeEntity;
import org.sandeep.model.Episode;
import org.sandeep.model.requests.EpisodeRequest;

import java.util.List;

public interface EpisodeService {

    List<Episode> getAllEpisodeByPodcastId(String podcastId);

    @Transactional
    Episode createEpisode(EpisodeRequest episodeRequest);
}
