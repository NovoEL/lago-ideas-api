package xyz.lagosoft.ideas.Projects.vo;

import xyz.lagosoft.ideas.APIs.AwesomeAPI;
import xyz.lagosoft.ideas.Projects.model.ChallengeEntry;
import xyz.lagosoft.ideas.Projects.model.SideProject;
import xyz.lagosoft.ideas.Projects.model.Stack;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class ProjectVO {

    private Long id;

    private Boolean isChallengeEntry;

    private Long challengeId;

    private BuilderVO owner;

    private String title;

    private String tagline;

    private String imageUrl;

    private String problem;

    private String solution;

    private Set<AwesomeAPI> apis = new HashSet<>();

    private Integer hoursToBuild;

    private String demoUrl;

    private String repoUrl;

    private Set<Stack> stacks = new HashSet<>();

    private Boolean isJamstack;

    private Date createdAt;

    // Staff Picks
    private Boolean isFeatured;

    private Integer updatesCount;

    private Integer supportersCount;

    private Integer commentsCount;

    public ProjectVO(SideProject project) {
        BeanUtils.copyProperties(project, this);
        this.owner = project.getOwnerVO();
        this.updatesCount = project.getUpdatesCount();
        this.supportersCount = project.getSupportersCount();
        this.commentsCount = project.getCommentsCount();
    }

    public ProjectVO(ChallengeEntry entry) {
        BeanUtils.copyProperties(entry, this);
        this.owner = entry.getOwnerVO();
        this.updatesCount = entry.getUpdatesCount();
        this.supportersCount = entry.getSupportersCount();
        this.commentsCount = entry.getCommentsCount();
    }

    public ProjectVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getChallengeEntry() {
        return isChallengeEntry;
    }

    public void setChallengeEntry(Boolean challengeEntry) {
        isChallengeEntry = challengeEntry;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public BuilderVO getOwner() {
        return owner;
    }

    public void setOwner(BuilderVO owner) {
        this.owner = owner;
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

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Set<AwesomeAPI> getApis() {
        return apis;
    }

    public void setApis(Set<AwesomeAPI> apis) {
        this.apis = apis;
    }

    public Integer getHoursToBuild() {
        return hoursToBuild;
    }

    public void setHoursToBuild(Integer hoursToBuild) {
        this.hoursToBuild = hoursToBuild;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public Set<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(Set<Stack> stacks) {
        this.stacks = stacks;
    }

    public Boolean getJamstack() {
        return isJamstack;
    }

    public void setJamstack(Boolean jamstack) {
        isJamstack = jamstack;
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

    public Integer getUpdatesCount() {
        return updatesCount;
    }

    public void setUpdatesCount(Integer updatesCount) {
        this.updatesCount = updatesCount;
    }

    public Integer getSupportersCount() {
        return supportersCount;
    }

    public void setSupportersCount(Integer supportersCount) {
        this.supportersCount = supportersCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }
}
