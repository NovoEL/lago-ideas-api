package xyz.lagosoft.ideas.Projects.model;

import xyz.lagosoft.ideas.APIs.AwesomeAPI;
import xyz.lagosoft.ideas.Builders.model.Comment;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.vo.CommentVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.BaseEntityB;
import xyz.lagosoft.ideas.common.enumeration.CommentableType;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "projects")
@Inheritance(strategy = InheritanceType.JOINED)
public class SideProject extends BaseEntityB {

    private Boolean isChallengeEntry;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Builder owner;

    @ManyToMany
    @JoinTable(name = "project_co_creator",
            joinColumns = {@JoinColumn(name = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "coCreatorId")})
    private Set<Builder> coCreators = new HashSet<>();

    private String title;

    private String tagline;

    private String imageUrl;

    private String problem;

    private String solution;

    @ManyToMany
    @JoinTable(name = "project_api",
            joinColumns = {@JoinColumn(name = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "apiId")})
    private Set<AwesomeAPI> apis = new HashSet<>();

    private Integer hoursToBuild;

    private String demoUrl;

    private String repoUrl;

    @ManyToMany
    @JoinTable(name = "project_stack",
            joinColumns = {@JoinColumn(name = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "stackId")})
    private Set<xyz.lagosoft.ideas.Projects.model.Stack> stacks = new HashSet<>();

    private Boolean isJamstack;

    // Staff Picks
    private Boolean isFeatured;

    @OneToMany
    @JoinColumn(name = "projectId")
    private List<Update> updates = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Support> supporters = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "commentableId")
    private List<Comment> comments = new ArrayList<>();

    public Boolean getChallengeEntry() {
        return isChallengeEntry;
    }

    public void setChallengeEntry(Boolean challengeEntry) {
        isChallengeEntry = challengeEntry;
    }

    public Builder getOwner() {
        return owner;
    }

    public void setOwner(Builder owner) {
        this.owner = owner;
    }

    public Set<Builder> getCoCreators() {
        return coCreators;
    }

    public void setCoCreators(Set<Builder> coCreators) {
        this.coCreators = coCreators;
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

    public Set<AwesomeAPI> getAPIs() {
        return apis;
    }

    public void setAPIs(Set<AwesomeAPI> apis) {
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

    public Set<xyz.lagosoft.ideas.Projects.model.Stack> getStacks() {
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

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public List<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    public List<Support> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<Support> supporters) {
        this.supporters = supporters;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public BuilderVO getOwnerVO() {
        return new BuilderVO(owner);
    }

    public void addCoCreator(Builder coCreator) {
        this.coCreators.add(coCreator);
    }
    public void removeCoCreator(Builder coCreator) {
        coCreators.remove(coCreator);
    }

    public List<String> getCoCreatorList() {
        List<String> coCreatorList = new ArrayList<>();
        for (Builder coCreator : coCreators) {
            coCreatorList.add(coCreator.getUsername());
        }
        return coCreatorList;
    }

    public void addUpdate(Update update) {
        updates.add(update);
        update.setProjectId(this.getId());
    }
    public void removeUpdate(Update update) {
        updates.remove(update);
    }

    public Integer getUpdatesCount() {
        return updates.size();
    }

    public void addSupporter(Support support) {
        supporters.add(support);
        support.setProject(this);
    }
    public void removeSupporter(Support support) {
        supporters.remove(support);
    }

    public Integer getSupportersCount() {
        return supporters.size();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommentableType(CommentableType.PROJECT);
        comment.setCommentableId(this.getId());
    }
    public void removeComment(Comment comment)  {
        comments.remove(comment);
    }

    public Integer getCommentsCount() {
        return comments.size();
    }
    public List<CommentVO> getCommentList() {
        List<CommentVO> commentList = new ArrayList<>();
        for (Comment comment : comments) {
            commentList.add(new CommentVO(comment));
        }
        return commentList;
    }

}
