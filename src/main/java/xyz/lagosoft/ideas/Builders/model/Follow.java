package xyz.lagosoft.ideas.Builders.model;

import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.BaseEntityC;

import jakarta.persistence.*;

@Entity
@Table(name = "follows")
public class Follow extends BaseEntityC {

    @ManyToOne
    @JoinColumn(name="followingId")
    private Builder following;

    @ManyToOne
    @JoinColumn(name="followerId")
    private Builder follower;

    public Follow(Builder following, Builder follower) {
        this.following = following;
        this.follower = follower;
    }

    public Follow() {
    }

    public Builder getFollowing() {
        return following;
    }

    public void setFollowing(Builder following) {
        this.following = following;
    }

    public Builder getFollower() {
        return follower;
    }

    public void setFollower(Builder follower) {
        this.follower = follower;
    }

    public BuilderVO getFollowingVO() {
        return new BuilderVO(following);
    }

    public BuilderVO getFollowerVO() {
        return new BuilderVO(follower);
    }

}
