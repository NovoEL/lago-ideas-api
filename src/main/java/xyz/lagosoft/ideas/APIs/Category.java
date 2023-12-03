package xyz.lagosoft.ideas.APIs;

import xyz.lagosoft.ideas.common.BaseEntityB;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    private String imageUrl;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<AwesomeAPI> apis = new HashSet<>();

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AwesomeAPI> getApis() {
        return apis;
    }

    public void setApis(Set<AwesomeAPI> apis) {
        this.apis = apis;
    }
}
