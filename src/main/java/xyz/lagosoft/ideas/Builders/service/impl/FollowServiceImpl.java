package xyz.lagosoft.ideas.Builders.service.impl;

import xyz.lagosoft.ideas.Builders.model.Follow;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.repository.FollowRepository;
import xyz.lagosoft.ideas.Builders.service.FollowService;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private BuilderService builderService;

    public void follow(String username) {
        Builder following = builderService.retrieveBuilder(username);
        Builder follower = builderService.getCurrentBuilder();
        Optional<Follow> followOptional = Optional.ofNullable(followRepository.findFirstByFollowingAndFollower(following, follower));
        if (followOptional.isEmpty()) {
            Follow follow = new Follow(following, follower);
            follow.setCreatedAt(new Date());
            followRepository.save(follow);
            following.addFollower(follow);
            follower.addFollowing(follow);
            return;
        }
        Follow follow = followOptional.get();
        following.removeFollower(follow);
        follower.removeFollowing(follow);
        followRepository.delete(follow);
    }
}
