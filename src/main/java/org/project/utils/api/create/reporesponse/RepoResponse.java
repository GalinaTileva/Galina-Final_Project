package org.project.utils.api.create.reporesponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoResponse {
    private OwnerDetails owner;
    private PermissionsData permissions;
    @JsonProperty("merge_commit_message")
    private String mergeCommitMessage;
    @JsonProperty("created_at")
    private String createdAt;

    public OwnerDetails getOwner() {
        return owner;
    }

    public PermissionsData getPermissions() {
        return permissions;
    }

    public String getMergeCommitMessage() {
        return mergeCommitMessage;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
