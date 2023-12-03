package xyz.lagosoft.ideas.APIs;

import xyz.lagosoft.ideas.common.BaseEntityB;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "apis")
public class AwesomeAPI extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    private String logoUrl;

    private String websiteUrl;

    private String description;

    @ManyToMany
    @JoinTable(name = "api_category",
            joinColumns = {@JoinColumn(name = "apiId")},
            inverseJoinColumns = {@JoinColumn(name = "categoryId")})
    private Set<Category> categories = new HashSet<>();

    private Boolean isFeatured;

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }
}

