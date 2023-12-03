package xyz.lagosoft.ideas.Projects.model;

import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "entries")
public class ChallengeEntry extends SideProject {

    @ManyToOne
    @JoinColumn(name = "challengeId")
    private SDGSolutionChallenge challenge;

    //SDG: SUSTAINABLE DEVELOPMENT GOAL
    @ManyToMany
    @JoinTable(name = "project_sdg",
            joinColumns = {@JoinColumn(name = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "sdgId")})
    private Set<SDG> sdgs = new HashSet<>();

    public SDGSolutionChallenge getChallenge() {
        return challenge;
    }

    public void setChallenge(SDGSolutionChallenge challenge) {
        this.challenge = challenge;
    }

    public Set<SDG> getSDGs() {
        return sdgs;
    }

    public void setSDGs(Set<SDG> sdgs) {
        this.sdgs = sdgs;
    }
}
