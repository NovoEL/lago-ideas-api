package xyz.lagosoft.ideas.Challenges.model;

import xyz.lagosoft.ideas.Challenges.vo.AnswerVO;
import xyz.lagosoft.ideas.Builders.model.Comment;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.vo.CommentVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.BaseEntityB;
import xyz.lagosoft.ideas.common.enumeration.CommentableType;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question extends BaseEntityB {

    private Long challengeId;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Builder author;

    private String title;

    private String body;

    @OneToMany
    @JoinColumn(name = "questionId")
    private List<Answer> answers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "commentableId")
    private List<Comment> comments = new ArrayList<>();

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public Builder getAuthor() {
        return author;
    }

    public void setAuthor(Builder author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public BuilderVO getAuthorVO() {
        return new BuilderVO(author);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestionId(this.getId());
    }
    public void removeAnswer(Answer answer)  {
        answers.remove(answer);
    }
    public Integer getAnswersCount() {
        return answers.size();
    }

    public List<AnswerVO> getAnswerList() {
        List<AnswerVO> answerList = new ArrayList<>();
        for (Answer answer : answers) {
            answerList.add(new AnswerVO(answer));
        }
        return answerList;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommentableType(CommentableType.QUESTION);
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
