package xyz.lagosoft.ideas.Builders.vo;

import xyz.lagosoft.ideas.Challenges.vo.ChallengeVO;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;
import xyz.lagosoft.ideas.Builders.model.Builder;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuilderProfileVO {

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

    private List<ProjectVO> ownedProjects = new ArrayList<>();

    private Integer coCreatedProjectsCount;

    private List<ProjectVO> coCreatedProjects = new ArrayList<>();

    private Integer followersCount;

    private List<BuilderVO> followers = new ArrayList<>();

    private Integer followingCount;

    private List<BuilderVO> following = new ArrayList<>();

    private Integer followedChallengesCount;

    private List<ChallengeVO> followedChallenges = new ArrayList<>();

    private Integer supportingCount;

    private List<ProjectVO> supporting = new ArrayList<>();

    private Integer bookmarksCount;

    private BookmarksVO bookmarks;

    public BuilderProfileVO(Builder builder) {
        BeanUtils.copyProperties(builder, this);
        this.ownedProjectsCount = builder.getOwnedProjectsCount();
        this.ownedProjects = builder.getOwnedProjectList();
        this.coCreatedProjectsCount = builder.getCoCreatedProjectsCount();
        this.coCreatedProjects = builder.getCoCreatedProjectList();
        this.followersCount = builder.getFollowersCount();
        this.followers = builder.getFollowerList();
        this.followingCount = builder.getFollowingCount();
        this.following = builder.getFollowingList();
        this.followedChallengesCount = builder.getFollowedChallengesCount();
        this.followedChallenges = builder.getFollowedChallengeList();
        this.supportingCount = builder.getSupportingCount();
        this.supporting = builder.getSupportingList();
        this.bookmarksCount = builder.getBookmarksCount();
        this.bookmarks = builder.getBookmarksVO();
    }

    public BuilderProfileVO() {
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

    public List<ProjectVO> getOwnedProjects() {
        return ownedProjects;
    }

    public void setOwnedProjects(List<ProjectVO> ownedProjects) {
        this.ownedProjects = ownedProjects;
    }

    public Integer getCoCreatedProjectsCount() {
        return coCreatedProjectsCount;
    }

    public void setCoCreatedProjectsCount(Integer coCreatedProjectsCount) {
        this.coCreatedProjectsCount = coCreatedProjectsCount;
    }

    public List<ProjectVO> getCoCreatedProjects() {
        return coCreatedProjects;
    }

    public void setCoCreatedProjects(List<ProjectVO> coCreatedProjects) {
        this.coCreatedProjects = coCreatedProjects;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public List<BuilderVO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<BuilderVO> followers) {
        this.followers = followers;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public List<BuilderVO> getFollowing() {
        return following;
    }

    public void setFollowing(List<BuilderVO> following) {
        this.following = following;
    }

    public Integer getFollowedChallengesCount() {
        return followedChallengesCount;
    }

    public void setFollowedChallengesCount(Integer followedChallengesCount) {
        this.followedChallengesCount = followedChallengesCount;
    }

    public List<ChallengeVO> getFollowedChallenges() {
        return followedChallenges;
    }

    public void setFollowedChallenges(List<ChallengeVO> followedChallenges) {
        this.followedChallenges = followedChallenges;
    }

    public Integer getSupportingCount() {
        return supportingCount;
    }

    public void setSupportingCount(Integer supportingCount) {
        this.supportingCount = supportingCount;
    }

    public List<ProjectVO> getSupporting() {
        return supporting;
    }

    public void setSupporting(List<ProjectVO> supporting) {
        this.supporting = supporting;
    }

    public Integer getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(Integer bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public BookmarksVO getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(BookmarksVO bookmarks) {
        this.bookmarks = bookmarks;
    }
}
