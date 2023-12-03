package xyz.lagosoft.ideas.Builders.vo;

import xyz.lagosoft.ideas.Builders.model.Builder;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BuilderVO {
    private Long id;

    private String name;

    private String username;

    private String avatarUrl;

    private String headline;

    private String bio;

    private String websiteUrl;

    private String location;

    private Date createdAt;

    private Date updatedAt;

    private Integer ownedProjectsCount;

    private Integer coCreatedProjectsCount;

    private Integer followersCount;

    private Integer followingCount;

    private Integer followedChallengesCount;

    private Integer supportingCount;

    private Integer bookmarksCount;

    public BuilderVO(Builder builder) {
        BeanUtils.copyProperties(builder, this);
        this.ownedProjectsCount = builder.getOwnedProjectsCount();
        this.coCreatedProjectsCount = builder.getCoCreatedProjectsCount();
        this.followersCount = builder.getFollowersCount();
        this.followingCount = builder.getFollowingCount();
        this.followedChallengesCount = builder.getFollowedChallengesCount();
        this.supportingCount = builder.getSupportingCount();
        this.bookmarksCount = builder.getBookmarksCount();
    }

    public BuilderVO() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getOwnedProjectsCount() {
        return ownedProjectsCount;
    }

    public void setOwnedProjectsCount(Integer ownedProjectsCount) {
        this.ownedProjectsCount = ownedProjectsCount;
    }

    public Integer getCoCreatedProjectsCount() {
        return coCreatedProjectsCount;
    }

    public void setCoCreatedProjectsCount(Integer coCreatedProjectsCount) {
        this.coCreatedProjectsCount = coCreatedProjectsCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getFollowedChallengesCount() {
        return followedChallengesCount;
    }

    public void setFollowedChallengesCount(Integer followedChallengesCount) {
        this.followedChallengesCount = followedChallengesCount;
    }

    public Integer getSupportingCount() {
        return supportingCount;
    }

    public void setSupportingCount(Integer supportingCount) {
        this.supportingCount = supportingCount;
    }

    public Integer getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(Integer bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }
}
