package xyz.lagosoft.ideas.Builders.vo;

import xyz.lagosoft.ideas.Builders.model.Bookmark;

import java.util.ArrayList;
import java.util.List;

public class BookmarksVO {

    private Integer projectBookmarksCount;

    private List<Long> projectBookmarks = new ArrayList<>();

    private Integer apiBookmarksCount;

    private List<Long> apiBookmarks = new ArrayList<>();

    public Integer getProjectBookmarksCount() {
        return projectBookmarksCount;
    }

    public void setProjectBookmarksCount(Integer projectBookmarksCount) {
        this.projectBookmarksCount = projectBookmarksCount;
    }

    public List<Long> getProjectBookmarks() {
        return projectBookmarks;
    }

    public void setProjectBookmarks(List<Long> projectBookmarks) {
        this.projectBookmarks = projectBookmarks;
    }

    public Integer getApiBookmarksCount() {
        return apiBookmarksCount;
    }

    public void setApiBookmarksCount(Integer apiBookmarksCount) {
        this.apiBookmarksCount = apiBookmarksCount;
    }

    public List<Long> getApiBookmarks() {
        return apiBookmarks;
    }

    public void setApiBookmarks(List<Long> apiBookmarks) {
        this.apiBookmarks = apiBookmarks;
    }

    public void addProjectBookmark(Bookmark bookmark) {
        projectBookmarks.add(bookmark.getBookmarkableId());
        projectBookmarksCount++;
    }

    public void addToolBookmark(Bookmark bookmark) {
        apiBookmarks.add(bookmark.getBookmarkableId());
        apiBookmarksCount++;
    }

}
