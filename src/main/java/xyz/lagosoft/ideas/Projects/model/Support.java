package xyz.lagosoft.ideas.Projects.model;

import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.common.BaseEntityC;

import jakarta.persistence.*;

@Entity
@Table(name = "supports")
public class Support extends BaseEntityC {

    @ManyToOne
    @JoinColumn(name = "projectId")
    private SideProject project;

    @ManyToOne
    @JoinColumn(name = "builderId")
    private Builder builder;

    public Support(SideProject project, Builder builder) {
        this.project = project;
        this.builder = builder;
    }

    public Support() {
    }

    public SideProject getProject() {
        return project;
    }

    public void setProject(SideProject project) {
        this.project = project;
    }

    public Builder getUser() {
        return builder;
    }

    public void setUser(Builder builder) {
        this.builder = builder;
    }
}

