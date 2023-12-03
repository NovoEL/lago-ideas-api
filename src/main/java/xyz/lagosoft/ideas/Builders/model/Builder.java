package xyz.lagosoft.ideas.Builders.model;

import xyz.lagosoft.ideas.Challenges.vo.ChallengeVO;
import xyz.lagosoft.ideas.Projects.model.SideProject;
import xyz.lagosoft.ideas.Projects.model.Support;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;
import xyz.lagosoft.ideas.Challenges.model.ChallengeFollow;
import xyz.lagosoft.ideas.common.BaseEntityA;

import jakarta.persistence.*;
import xyz.lagosoft.ideas.Builders.vo.BookmarksVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "builders")
public class Builder extends BaseEntityA {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String username;

    private String avatarUrl;

    private String headline;

    private String bio;

    private String websiteUrl;

    private String location;

    @OneToMany(mappedBy = "owner")
    private List<SideProject> ownedProjects = new ArrayList<>();

    @ManyToMany(mappedBy = "coCreators")
    private List<SideProject> coCreatedProjects;

    @OneToMany(mappedBy = "following")
    private List<Follow> followers = new ArrayList<>();

    @OneToMany(mappedBy = "follower")
    private List<Follow> following = new ArrayList<>();

    @OneToMany(mappedBy = "builder")
    private List<ChallengeFollow> challengeFollows = new ArrayList<>();

    @OneToMany(mappedBy = "builder")
    private List<Support> supporting = new ArrayList<>();

    @OneToMany(mappedBy = "builder")
    private List<Bookmark> bookmarks = new ArrayList<>();

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

    public List<SideProject> getOwnedProjects() {
        return ownedProjects;
    }

    public void setOwnedProjects(List<SideProject> ownedProjects) {
        this.ownedProjects = ownedProjects;
    }

    public List<SideProject> getCoCreatedProjects() {
        return coCreatedProjects;
    }

    public void setCoCreatedProjects(List<SideProject> coCreatedProjects) {
        this.coCreatedProjects = coCreatedProjects;
    }

    public List<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follow> followers) {
        this.followers = followers;
    }

    public List<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follow> following) {
        this.following = following;
    }

    public List<ChallengeFollow> getChallengeFollows() {
        return challengeFollows;
    }

    public void setChallengeFollows(List<ChallengeFollow> challengeFollows) {
        this.challengeFollows = challengeFollows;
    }

    public List<Support> getSupporting() {
        return supporting;
    }

    public void setSupporting(List<Support> supporting) {
        this.supporting = supporting;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public void addOwnedProject(SideProject project) {
        ownedProjects.add(project);
        project.setOwner(this);
    }
    public void removeOwnedProject(SideProject project)  {
        ownedProjects.remove(project);
    }

    public Integer getOwnedProjectsCount() {
        return ownedProjects.size();
    }

    public List<ProjectVO> getOwnedProjectList() {
        List<ProjectVO> projectList = new ArrayList<>();
        for (SideProject project : ownedProjects) {
            projectList.add(new ProjectVO(project));
        }
        return projectList;
    }

    public void addCoCreatedProject(SideProject project) {
        coCreatedProjects.add(project);
    }
    public void removeCoCreatedProject(SideProject project)  {
        coCreatedProjects.remove(project);
    }

    public Integer getCoCreatedProjectsCount() {
        return coCreatedProjects.size();
    }

    public List<ProjectVO> getCoCreatedProjectList() {
        List<ProjectVO> projectList = new ArrayList<>();
        for (SideProject project : coCreatedProjects) {
            projectList.add(new ProjectVO(project));
        }
        return projectList;
    }

    public void addChallenge(ChallengeFollow follow) {
        challengeFollows.add(follow);
        follow.setUser(this);
    }
    public void removeChallenge(ChallengeFollow follow)  {
        challengeFollows.remove(follow);
    }

    public Integer getFollowedChallengesCount() {
        return challengeFollows.size();
    }

    public List<ChallengeVO> getFollowedChallengeList() {
        List<ChallengeVO> challengeList = new ArrayList<>();
        for (ChallengeFollow follow : challengeFollows) {
            challengeList.add(follow.getChallengeVO());
        }
        return challengeList;
    }

    public void addFollower(Follow follow) {
        followers.add(follow);
        follow.setFollowing(this);
    }
    public void removeFollower(Follow follow)  {
        followers.remove(follow);
    }

    public Integer getFollowersCount() {
        return followers.size();
    }

    public List<BuilderVO> getFollowerList() {
        List<BuilderVO> followerList = new ArrayList<>();
        for (Follow follow : followers) {
            followerList.add(follow.getFollowerVO());
        }
        return followerList;
    }

    public void addFollowing(Follow follow) {
        following.add(follow);
        follow.setFollowing(this);
    }
    public void removeFollowing(Follow follow)  {
        following.remove(follow);
    }

    public Integer getFollowingCount() {
        return following.size();
    }

    public List<BuilderVO> getFollowingList() {
        List<BuilderVO> followingList = new ArrayList<>();
        for (Follow follow : following) {
            followingList.add(follow.getFollowingVO());
        }
        return followingList;
    }

    public void addSupporting(Support support) {
        this.supporting.add(support);
        support.setUser(this);
    }

    public void removeSupporting(Support support) {
        supporting.remove(support);
    }

    public Integer getSupportingCount() {
        return supporting.size();
    }

    public List<ProjectVO> getSupportingList() {
        List<ProjectVO> supportingList = new ArrayList<>();
        for (Support support : supporting) {
            supportingList.add(new ProjectVO(support.getProject()));
        }
        return supportingList;
    }

    public void addBookmark(Bookmark bookmark) {
        this.bookmarks.add(bookmark);
        bookmark.setUser(this);
    }

    public void removeBookmark(Bookmark bookmark) {
        bookmarks.remove(bookmark);
    }

    public Integer getBookmarksCount() {
        return bookmarks.size();
    }

    public BookmarksVO getBookmarksVO() {
        BookmarksVO bookmarksVO = new BookmarksVO();
        for (Bookmark bookmark : bookmarks) {
            switch (bookmark.getBookmarkableType()) {
                case PROJECT:
                    bookmarksVO.addProjectBookmark(bookmark);
                    break;
                case API:
                    bookmarksVO.addToolBookmark(bookmark);
                    break;
            }
        }
        return bookmarksVO;
    }

}
