package xyz.lagosoft.ideas.Challenges.model;

import xyz.lagosoft.ideas.Challenges.vo.ChallengeVO;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.BaseEntityC;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "challenge_follows")
public class ChallengeFollow extends BaseEntityC {

    @ManyToOne
    @JoinColumn(name = "challengeId")
    private SDGSolutionChallenge challenge;

    @ManyToOne
    @JoinColumn(name = "builderId")
    private Builder builder;

    public ChallengeFollow(SDGSolutionChallenge challenge, Builder builder) {
        this.challenge = challenge;
        this.builder = builder;
    }

    public ChallengeFollow() {
    }

    public SDGSolutionChallenge getChallenge() {
        return challenge;
    }

    public void setChallenge(SDGSolutionChallenge challenge) {
        this.challenge = challenge;
    }

    public Builder getUser() {
        return builder;
    }

    public void setUser(Builder builder) {
        this.builder = builder;
    }

    public ChallengeVO getChallengeVO() {
        return new ChallengeVO(challenge);
    }

    public BuilderVO getUserVO() {
        return new BuilderVO(builder);
    }
}
