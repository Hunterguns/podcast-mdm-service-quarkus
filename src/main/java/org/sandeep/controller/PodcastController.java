package org.sandeep.controller;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import org.sandeep.model.Podcast;
import org.sandeep.model.PodcastRequest;
import org.sandeep.service.PodcastService;

import java.util.List;

@GraphQLApi
public class PodcastController {
    @Inject
    private PodcastService podcastService;

    @Query(value = "createPodcast")
    @Description("Create a new podcast")
    public Podcast createPodcast(@Source PodcastRequest podcastRequest){
        return podcastService.createPodcast(podcastRequest);
    }

    @Query(value = "filterPodcast")
    public List<Podcast> filterPodcast(@Source PodcastRequest podcastRequest){
        return podcastService.filterPodcast(podcastRequest);
    }
}
