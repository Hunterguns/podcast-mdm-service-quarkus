package org.sandeep.controller;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import org.sandeep.model.Episode;
import org.sandeep.model.Podcast;
import org.sandeep.model.requests.PodcastRequest;
import org.sandeep.service.EpisodeService;
import org.sandeep.service.PodcastService;

import java.util.List;

@GraphQLApi
public class PodcastController {
    @Inject
    private PodcastService podcastService;

    @Inject
    private EpisodeService episodeService;

    @Query(value = "createPodcast")
    @Description("Create a new podcast")
    public Podcast createPodcast(@Source PodcastRequest podcastRequest){
        return podcastService.createPodcast(podcastRequest);
    }

    @Query(value = "filterPodcast")
    public List<Podcast> filterPodcast(@Source PodcastRequest podcastRequest){
        return podcastService.filterPodcast(podcastRequest);
    }

    @Query(value = "deletePodcast")
    public String deletePodcast(@Source String podcastId){
        Boolean status = podcastService.deletePodcastById(podcastId);
        if(status){
            return "Podcast and related episodes deleted successfully";
        }else{
            return "Unable to delete podcast and related episodes. Something went wrong";
        }
    }

    @Query(value = "getEpisodes")
    public List<Episode> episodes(@Source String podcastId){
        return episodeService.getAllEpisodeByPodcastId(podcastId);
    }
}
