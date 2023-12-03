package xyz.lagosoft.ideas.Builders.model;

import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.BaseEntityC;
import xyz.lagosoft.ideas.common.enumeration.CommentableType;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntityC {

    private CommentableType commentableType;

    private Long commentableId;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Builder author;

    private String text;

    public CommentableType getCommentableType() {
        return commentableType;
    }

    public void setCommentableType(CommentableType commentableType) {
        this.commentableType = commentableType;
    }

    public Long getCommentableId() {
        return commentableId;
    }

    public void setCommentableId(Long commentableId) {
        this.commentableId = commentableId;
    }

    public Builder getAuthor() {
        return author;
    }

    public void setAuthor(Builder author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BuilderVO getAuthorVO() {
        return new BuilderVO(author);
    }

}
