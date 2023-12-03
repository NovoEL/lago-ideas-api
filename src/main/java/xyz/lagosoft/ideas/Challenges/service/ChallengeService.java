package xyz.lagosoft.ideas.Challenges.service;

import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.Challenges.vo.ChallengeVO;
import xyz.lagosoft.ideas.Challenges.vo.QuestionVO;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;

import java.util.List;

public interface ChallengeService {

    List<ChallengeVO> retrieveAllChallenges();

    ChallengeVO retrieveChallenge(String slug);

    List<BuilderVO> retrieveChallengeFollowers(String slug);

    List<QuestionVO> retrieveChallengeQuestions(String slug);

    List<ProjectVO> retrieveChallengeEntries(String slug);

}
