package xyz.lagosoft.ideas.Builders.repository;

import xyz.lagosoft.ideas.Builders.model.Bookmark;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.common.enumeration.BookmarkableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Bookmark findFirstByBookmarkableTypeAndBookmarkableIdAndBuilder(BookmarkableType bookmarkableType, Long bookmarkableId, Builder builder);
}
