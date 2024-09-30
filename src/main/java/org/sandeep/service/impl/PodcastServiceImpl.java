package org.sandeep.service.impl;

import com.google.common.base.Strings;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.sandeep.core.entity.PodcastEntity;
import org.sandeep.model.Podcast;
import org.sandeep.model.PodcastRequest;
import org.sandeep.service.PodcastService;

import java.util.List;
import java.util.Objects;

@Slf4j
@ApplicationScoped
public class PodcastServiceImpl implements PodcastService {
    @Override
    @Transactional
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
    public List<Podcast> filterPodcast(PodcastRequest podcastRequest) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("1=1");

        PanacheQuery<PanacheEntityBase> query = PodcastEntity.find(queryBuilder.toString());
        if(!Strings.isNullOrEmpty(podcastRequest.getTitle())){
            queryBuilder.append(" and title = :title");
            query = query.withHint("title", podcastRequest.getTitle());
        }
        if(podcastRequest.getCreatorId() != null){
            queryBuilder.append("and creatorId = :creatorId");
            query = query.withHint("creatorId", podcastRequest.getCreatorId());
        }
        if(!Strings.isNullOrEmpty(podcastRequest.getLanguage())){
            queryBuilder.append("and language = :language");
            query = query.withHint("language", podcastRequest.getLanguage());
        }

        List<PodcastEntity> list = query.list();
        return list.stream().map(podcastEntity-> PodcastEntity.toPodcast.apply(podcastEntity)).toList();
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
