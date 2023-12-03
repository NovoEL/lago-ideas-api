package xyz.lagosoft.ideas.Builders.repository;

import xyz.lagosoft.ideas.Builders.model.Follow;
import xyz.lagosoft.ideas.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow findFirstByFollowingAndFollower(Builder following, Builder follower);
}
