package org.sandeep.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import lombok.extern.slf4j.Slf4j;
import org.sandeep.core.entity.PodcastEntity;
import org.sandeep.model.Podcast;
import org.sandeep.model.PodcastRequest;
import org.sandeep.service.PodcastService;

import java.util.Objects;

@Slf4j
@ApplicationScoped
public class PodcastServiceImpl implements PodcastService {
    @Override
    public Podcast createPodcast(PodcastRequest podcastRequest) {
        PodcastEntity existingPodcast = PodcastEntity.findByCreatorIdAndTitle(podcastRequest.getCreatorId(), podcastRequest.getTitle());
        if(Objects.nonNull(existingPodcast)){
            log.error("Podcast with title " + podcastRequest.getTitle() + "was already created by the user.");
        }
        PodcastEntity podcastEntity = PodcastRequest.toPodcastEntity.apply(podcastRequest);
        PodcastEntity.persist(podcastEntity);
        return PodcastEntity.toPodcast.apply(podcastEntity);
    }

    @Override
    public Podcast getPodcast(PodcastRequest podcastRequest) {
        return null;
    }

    @Override
    public Podcast getPodcastById(String id){
        PodcastEntity podcastEntity = PodcastEntity.findById(id, LockModeType.NONE);
        return PodcastEntity.toPodcast.apply(podcastEntity);
    }

    @Override
    public String updatePodcast(PodcastRequest podcastRequest) {
        return null;
    }

    @Override
    public String deletePodcastById(String podcastId) {
        return null;
    }
}
