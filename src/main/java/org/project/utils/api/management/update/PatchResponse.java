package org.project.utils.api.management.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatchResponse {
    private String name;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("has_projects")
    private boolean hasProjects;

    public String getName() {
        return name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public boolean isHasProjects() {
        return hasProjects;
    }

}
