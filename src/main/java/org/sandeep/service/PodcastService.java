package org.sandeep.service;

import org.sandeep.model.Podcast;
import org.sandeep.model.PodcastRequest;

import java.util.List;

public interface PodcastService {
    Podcast createPodcast(PodcastRequest podcastRequest);
    List<Podcast> filterPodcast(PodcastRequest podcastRequest);

    Podcast getPodcastById(String id);

    String updatePodcast(PodcastRequest podcastRequest);
    String deletePodcastById(String podcastId);
}
