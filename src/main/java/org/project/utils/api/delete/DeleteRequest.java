package org.project.utils.api.delete;
public class DeleteRequest {
    private String repoNameDelete;
    private String username;

    public String getRepoNameDelete() {
        return repoNameDelete;
    }

    public String getUsername() {
        return username;
    }

    public void setRepoNameDelete(String repoNameDelete) {
        this.repoNameDelete = repoNameDelete;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
