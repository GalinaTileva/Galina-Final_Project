package org.project.utils.api.create.reporesponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionsData {
    private boolean admin;
    private boolean push;
    private boolean pull;

    public boolean isAdmin() {
        return admin;
    }

    public boolean isPush() {
        return push;
    }

    public boolean isPull() {
        return pull;
    }
}
