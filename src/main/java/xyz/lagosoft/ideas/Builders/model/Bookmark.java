package xyz.lagosoft.ideas.Builders.model;

import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.BaseEntityC;
import xyz.lagosoft.ideas.common.enumeration.BookmarkableType;

import jakarta.persistence.*;

@Entity
@Table(name = "bookmarks")
public class Bookmark extends BaseEntityC {

    private BookmarkableType bookmarkableType;

    private Long bookmarkableId;

    @ManyToOne
    @JoinColumn(name = "builderId")
    private Builder builder;

    public Bookmark(BookmarkableType bookmarkableType, Long bookmarkableId, Builder builder) {
        this.bookmarkableType = bookmarkableType;
        this.bookmarkableId = bookmarkableId;
        this.builder = builder;
    }

    public Bookmark() {
    }

    public BookmarkableType getBookmarkableType() {
        return bookmarkableType;
    }

    public void setBookmarkableType(BookmarkableType bookmarkableType) {
        this.bookmarkableType = bookmarkableType;
    }

    public Long getBookmarkableId() {
        return bookmarkableId;
    }

    public void setBookmarkableId(Long bookmarkableId) {
        this.bookmarkableId = bookmarkableId;
    }

    public Builder getUser() {
        return builder;
    }

    public void setUser(Builder builder) {
        this.builder = builder;
    }

    public BuilderVO getUserVO() {
        return new BuilderVO(builder);
    }

}
