package xyz.lagosoft.ideas.Challenges.service.impl;

import xyz.lagosoft.ideas.Challenges.model.ChallengeFollow;
import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;
import xyz.lagosoft.ideas.Challenges.repository.ChallengeFollowRepository;
import xyz.lagosoft.ideas.Challenges.repository.ChallengeRepository;
import xyz.lagosoft.ideas.Challenges.service.ChallengeFollowService;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class ChallengeFollowServiceImpl implements ChallengeFollowService {

    @Autowired
    private ChallengeFollowRepository followRepository;

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private BuilderService builderService;

    public void follow(String slug) {
        SDGSolutionChallenge challenge = Optional.ofNullable(challengeRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
        Builder builder = builderService.getCurrentBuilder();
        Optional<ChallengeFollow> followOptional = Optional.ofNullable(followRepository.findFirstByChallengeAndBuilder(challenge, builder));
        if (followOptional.isEmpty()) {
            ChallengeFollow follow = new ChallengeFollow(challenge, builder);
            follow.setCreatedAt(new Date());
            followRepository.save(follow);
            challenge.addFollower(follow);
            builder.addChallenge(follow);
            return;
        }
        ChallengeFollow follow = followOptional.get();
        challenge.removeFollower(follow);
        builder.removeChallenge(follow);
        followRepository.delete(follow);
    }
}
