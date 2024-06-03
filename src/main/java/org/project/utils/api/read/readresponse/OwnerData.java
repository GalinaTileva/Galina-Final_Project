package org.project.utils.api.read.readresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerData {
    private int id;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("gravatar_id")
    private String gravatarId;
    @JsonProperty("site_admin")
    private boolean siteAdmin;

    public int getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }
}
