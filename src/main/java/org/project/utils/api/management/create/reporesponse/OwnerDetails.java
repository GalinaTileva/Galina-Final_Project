package org.project.utils.api.management.create.reporesponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerDetails {
    private String type;
    @JsonProperty("avatar_url")
    private String avatarUrl;

    public String getType() {
        return type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
