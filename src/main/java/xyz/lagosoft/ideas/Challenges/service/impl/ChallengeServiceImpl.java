package xyz.lagosoft.ideas.Challenges.service.impl;

import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.Challenges.vo.ChallengeVO;
import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;
import xyz.lagosoft.ideas.Challenges.repository.ChallengeRepository;
import xyz.lagosoft.ideas.Challenges.service.ChallengeService;
import xyz.lagosoft.ideas.Challenges.vo.QuestionVO;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    public List<ChallengeVO> retrieveAllChallenges() {
        return convertToChallengeVOs(challengeRepository.findAll());
    }

    public ChallengeVO retrieveChallenge(String slug) {
        SDGSolutionChallenge challenge = Optional.ofNullable(challengeRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
        return new ChallengeVO(challenge);
    }

    public List<BuilderVO> retrieveChallengeFollowers(String slug) {
        SDGSolutionChallenge challenge = challengeRepository.findBySlug(slug);
        return challenge.getFollowerList();
    }

    public List<QuestionVO> retrieveChallengeQuestions(String slug) {
        SDGSolutionChallenge challenge = challengeRepository.findBySlug(slug);
        return challenge.getQuestionList();
    }

    public List<ProjectVO> retrieveChallengeEntries(String slug) {
        SDGSolutionChallenge challenge = challengeRepository.findBySlug(slug);
        return challenge.getEntryList();
    }

    private List<ChallengeVO> convertToChallengeVOs(List<SDGSolutionChallenge> challenges) {
        List<ChallengeVO> challengeVOs = new ArrayList<>();
        for (SDGSolutionChallenge challenge : challenges) {
            challengeVOs.add(new ChallengeVO(challenge));
        }
        return challengeVOs;
    }

}
