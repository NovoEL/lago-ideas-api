package xyz.lagosoft.ideas.Challenges.vo;

import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class ChallengeVO {

    private Long id;

    private String name;

    private String slug;

    private String title;

    private String tagline;

    private String imageUrl;

    private String body;

    private Date createdAt;

    private Boolean isFeatured;

    private Integer followersCount;

    private Integer questionsCount;

    private Integer entriesCount;

    public ChallengeVO(SDGSolutionChallenge challenge) {
        BeanUtils.copyProperties(challenge, this);
        this.followersCount = challenge.getFollowersCount();
        this.questionsCount = challenge.getQuestionsCount();
        this.entriesCount = challenge.getEntriesCount();
    }

    public ChallengeVO() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(Integer questionsCount) {
        this.questionsCount = questionsCount;
    }

    public Integer getEntriesCount() {
        return entriesCount;
    }

    public void setEntriesCount(Integer entriesCount) {
        this.entriesCount = entriesCount;
    }
}

