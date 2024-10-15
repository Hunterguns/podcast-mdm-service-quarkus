package org.sandeep.service.impl;

import com.google.common.base.Strings;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.sandeep.core.entity.EpisodeEntity;
import org.sandeep.core.entity.PodcastEntity;
import org.sandeep.model.Podcast;
import org.sandeep.model.requests.PodcastRequest;
import org.sandeep.service.EpisodeService;
import org.sandeep.service.PodcastService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@ApplicationScoped
public class PodcastServiceImpl implements PodcastService {
    @Inject
    EpisodeService episodeService;

    @Override
    @Transactional
    public Podcast createPodcast(PodcastRequest podcastRequest) {
        PodcastEntity existingPodcast = PodcastEntity.findByCreatorIdAndTitle(podcastRequest.getCreatorId(), podcastRequest.getTitle());
        if (Objects.nonNull(existingPodcast)) {
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
        if (!Strings.isNullOrEmpty(podcastRequest.getTitle())) {
            queryBuilder.append(" and title = :title");
            query = query.withHint("title", podcastRequest.getTitle());
        }
        if (podcastRequest.getCreatorId() != null) {
            queryBuilder.append("and creatorId = :creatorId");
            query = query.withHint("creatorId", podcastRequest.getCreatorId());
        }
        if (!Strings.isNullOrEmpty(podcastRequest.getLanguage())) {
            queryBuilder.append("and language = :language");
            query = query.withHint("language", podcastRequest.getLanguage());
        }

        List<PodcastEntity> list = query.list();
        return list.stream().map(podcastEntity -> PodcastEntity.toPodcast.apply(podcastEntity)).toList();
    }

    @Override
    public Podcast getPodcastById(String id) {
        PodcastEntity podcastEntity = PodcastEntity.findById(id, LockModeType.NONE);
        return PodcastEntity.toPodcast.apply(podcastEntity);
    }

    @Override
    public Boolean updatePodcast(PodcastRequest podcastRequest) {
        PodcastEntity podcastEntity = PodcastEntity.findById(podcastRequest.getId());
        PodcastEntity updatedPodcastEntity = PodcastEntity.builder()
                .id(podcastEntity.getId())
                .creatorId(podcastEntity.getCreatorId())
                .title(Strings.isNullOrEmpty(podcastRequest.getTitle()) ? podcastEntity.getTitle() : podcastRequest.getTitle())
                .language(Strings.isNullOrEmpty(podcastRequest.getLanguage()) ? podcastEntity.getLanguage() : podcastRequest.getLanguage())
                .isExplicit(Objects.isNull(podcastRequest.isExplicit()) ? podcastEntity.isExplicit() : podcastRequest.isExplicit())
                .description(Strings.isNullOrEmpty(podcastRequest.getDescription()) ? podcastEntity.getDescription() : podcastRequest.getDescription())
                .coverImageUrl(Strings.isNullOrEmpty(podcastRequest.getCoverImageUrl()) ? podcastEntity.getCoverImageUrl() : podcastRequest.getCoverImageUrl())
                .createdAt(podcastEntity.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();

        PodcastEntity.persist(updatedPodcastEntity);
        log.info("Successfully updated podcast with id: " + podcastRequest.getId());
        return true;
    }

    @Override
    public Boolean deletePodcastById(String podcastId) {
        EpisodeEntity.delete("podcastId = ?1", podcastId);
        PodcastEntity.delete("id = ?1", podcastId);
        return true;
    }
}
