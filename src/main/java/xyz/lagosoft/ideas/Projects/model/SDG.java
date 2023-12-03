package xyz.lagosoft.ideas.Projects.model;

import xyz.lagosoft.ideas.common.BaseEntityB;

import jakarta.persistence.*;

//SDG: SUSTAINABLE DEVELOPMENT GOAL

@Entity
@Table(name = "sdgs")
public class SDG extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}

