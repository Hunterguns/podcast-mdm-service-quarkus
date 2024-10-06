package org.sandeep.controller;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import org.sandeep.model.Episode;
import org.sandeep.model.requests.EpisodeRequest;
import org.sandeep.service.EpisodeService;

@GraphQLApi
public class EpisodeController {
    @Inject
    EpisodeService episodeService;

    @Query(value = "createEpisode")
    @Description(value = "Add episode to a podcast")
    public Episode createEpisode(@Source EpisodeRequest episodeRequest){
        return episodeService.createEpisode(episodeRequest);
    }
}
