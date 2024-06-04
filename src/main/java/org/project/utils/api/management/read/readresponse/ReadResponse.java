package org.project.utils.api.management.read.readresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadResponse {
    private int id;
    @JsonProperty("node_id")
    private String nodeId;
    private boolean privateRepo;
    private OwnerData owner;

    public int getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("private")
    public boolean isPrivateRepo() {
        return privateRepo;
    }

    public OwnerData getOwner() {
        return owner;
    }
}
