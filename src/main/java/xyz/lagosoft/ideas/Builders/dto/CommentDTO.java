package xyz.lagosoft.ideas.Builders.dto;

import xyz.lagosoft.ideas.common.enumeration.CommentableType;

public class CommentDTO {

    private CommentableType commentableType;

    private Long commentableId;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
