package org.sandeep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.arc.All;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class FormData {
    @RestForm("file")
    public File file;

    @RestForm
    @PartType(MediaType.TEXT_PLAIN)
    public String fileName;

    @RestForm
    @PartType(MediaType.TEXT_PLAIN)
    public String mimeType;
}
