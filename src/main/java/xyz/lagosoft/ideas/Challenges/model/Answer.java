package xyz.lagosoft.ideas.Challenges.model;

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
@Table(name = "answers")
public class Answer extends BaseEntityB {

    private Long challengeId;

    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Builder author;

    private String content;

    @OneToMany
    @JoinColumn(name = "commentableId")
    private List<Comment> comments = new ArrayList<>();

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Builder getAuthor() {
        return author;
    }

    public void setAuthor(Builder author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommentableType(CommentableType.ANSWER);
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
