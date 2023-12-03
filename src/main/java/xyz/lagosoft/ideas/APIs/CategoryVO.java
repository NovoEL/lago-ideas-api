package xyz.lagosoft.ideas.APIs;

import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CategoryVO {

    private Long id;

    private String name;

    private String slug;

    private String imageUrl;

    private String description;

    private Date createdAt;

    private Integer apisCount;

    public CategoryVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getApisCount() {
        return apisCount;
    }

    public void setApisCount(Integer apisCount) {
        this.apisCount = apisCount;
    }
}
