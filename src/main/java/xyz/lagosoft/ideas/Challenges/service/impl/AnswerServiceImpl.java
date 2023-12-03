package xyz.lagosoft.ideas.Challenges.service.impl;

import xyz.lagosoft.ideas.Challenges.dto.AnswerDTO;
import xyz.lagosoft.ideas.Challenges.model.Answer;
import xyz.lagosoft.ideas.Challenges.model.Question;
import xyz.lagosoft.ideas.Challenges.repository.AnswerRepository;
import xyz.lagosoft.ideas.Challenges.repository.QuestionRepository;
import xyz.lagosoft.ideas.Challenges.service.AnswerService;
import xyz.lagosoft.ideas.Challenges.vo.AnswerVO;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private BuilderService builderService;

    public AnswerVO createAnswer(AnswerDTO dto) {
        Question question = questionRepository.findById(dto.getQuestionId()).orElseThrow(NotFoundException::new);
        Answer answer = new Answer();
        BeanUtils.copyProperties(dto, this);
        answer.setAuthor(builderService.getCurrentBuilder());
        answer.setCreatedAt(new Date());
        answerRepository.save(answer);
        question.addAnswer(answer);
        questionRepository.save(question);
        return new AnswerVO(answer);
    }

}
