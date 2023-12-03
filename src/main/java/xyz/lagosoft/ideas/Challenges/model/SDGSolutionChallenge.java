package xyz.lagosoft.ideas.Challenges.model;

import xyz.lagosoft.ideas.Challenges.vo.QuestionVO;
import xyz.lagosoft.ideas.Projects.model.ChallengeEntry;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.BaseEntityB;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "challenges")
public class SDGSolutionChallenge extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    private String title;

    private String tagline;

    private String imageUrl;

    private String body;

    private Boolean isFeatured;

    @OneToMany(mappedBy = "challenge")
    private List<ChallengeFollow> followers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "challengeId")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "challenge")
    private List<ChallengeEntry> entries = new ArrayList<>();

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

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public List<ChallengeFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<ChallengeFollow> followers) {
        this.followers = followers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addFollower(ChallengeFollow follow) {
        followers.add(follow);
        follow.setChallenge(this);
    }
    public void removeFollower(ChallengeFollow follow)  {
        followers.remove(follow);
    }

    public Integer getFollowersCount() {
        return followers.size();
    }

    public List<BuilderVO> getFollowerList() {
        List<BuilderVO> followerList = new ArrayList<>();
        for (ChallengeFollow follow : followers) {
            followerList.add(follow.getUserVO());
        }
        return followerList;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setChallengeId(this.getId());
    }
    public void removeQuestion(Question question)  {
        questions.remove(question);
    }

    public Integer getQuestionsCount() {
        return questions.size();
    }

    public List<QuestionVO> getQuestionList() {
        List<QuestionVO> questionList = new ArrayList<>();
        for (Question question : questions) {
            questionList.add(new QuestionVO(question));
        }
        return questionList;
    }

    public void setEntries(List<ChallengeEntry> entries) {
        this.entries = entries;
    }

    public void addEntry(ChallengeEntry entry) {
        entries.add(entry);
        entry.setChallenge(this);
    }
    public void removeEntry(ChallengeEntry entry)  {
        entries.remove(entry);
    }

    public Integer getEntriesCount() {
        return entries.size();
    }

    public List<ProjectVO> getEntryList() {
        List<ProjectVO> entryList = new ArrayList<>();
        for (ChallengeEntry entry : entries) {
            entryList.add(new ProjectVO(entry));
        }
        return entryList;
    }

}
