package xyz.lagosoft.ideas.Challenges.service.impl;

import xyz.lagosoft.ideas.Challenges.dto.QuestionDTO;
import xyz.lagosoft.ideas.Challenges.model.Question;
import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;
import xyz.lagosoft.ideas.Challenges.repository.ChallengeRepository;
import xyz.lagosoft.ideas.Challenges.repository.QuestionRepository;
import xyz.lagosoft.ideas.Challenges.service.QuestionService;
import xyz.lagosoft.ideas.Challenges.vo.QuestionVO;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private BuilderService builderService;

    public QuestionVO createQuestion(QuestionDTO dto) {
        SDGSolutionChallenge challenge = challengeRepository.findById(dto.getChallengeId()).orElseThrow(NotFoundException::new);
        Question question = new Question();
        BeanUtils.copyProperties(dto, this);
        question.setAuthor(builderService.getCurrentBuilder());
        question.setCreatedAt(new Date());
        questionRepository.save(question);
        challenge.addQuestion(question);
        challengeRepository.save(challenge);
        return new QuestionVO(question);
    }

    public QuestionVO retrieveQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(NotFoundException::new);
        return new QuestionVO(question);
    }
    private List<QuestionVO> convertToQuestionVOs(List<Question> questions) {
        List<QuestionVO> questionVOs = new ArrayList<>();
        for (Question question : questions) {
            questionVOs.add(new QuestionVO(question));
        }
        return questionVOs;
    }

}
