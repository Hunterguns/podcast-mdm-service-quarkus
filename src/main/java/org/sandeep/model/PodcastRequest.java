package org.sandeep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PodcastRequest {
    UUID id;
    UUID creatorId;
    String title;
    String description;
    String coverImageUrl;
    String language;
    boolean isExplicit;
}
