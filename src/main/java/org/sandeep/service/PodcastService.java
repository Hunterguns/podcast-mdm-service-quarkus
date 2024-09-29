package org.sandeep.service;

import org.sandeep.model.Podcast;
import org.sandeep.model.PodcastRequest;

public interface PodcastService {
    Podcast createPodcast(PodcastRequest podcastRequest);
    Podcast getPodcast(PodcastRequest podcastRequest);

    Podcast getPodcastById(String id);

    String updatePodcast(PodcastRequest podcastRequest);
    String deletePodcastById(String podcastId);
}
