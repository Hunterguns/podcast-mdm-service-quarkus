package org.sandeep.service;

import org.sandeep.core.entity.EpisodeEntity;
import org.sandeep.model.Episode;

import java.util.List;

public interface EpisodeService {

    List<Episode> getAllEpisodeByPodcastId(String podcastId);
}
