package xyz.lagosoft.ideas.Builders.vo;

import xyz.lagosoft.ideas.Builders.model.Comment;
import xyz.lagosoft.ideas.common.enumeration.CommentableType;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CommentVO {

    private Long id;

    private CommentableType commentableType;

    private Long commentableId;

    private BuilderVO author;

    private String text;

    private Date createdAt;

    public CommentVO(Comment comment) {
        BeanUtils.copyProperties(comment, this);
        this.author = comment.getAuthorVO();
    }

    public CommentVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BuilderVO getAuthor() {
        return author;
    }

    public void setAuthor(BuilderVO author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
