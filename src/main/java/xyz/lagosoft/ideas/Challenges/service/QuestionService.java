package xyz.lagosoft.ideas.Challenges.service;

import xyz.lagosoft.ideas.Challenges.dto.QuestionDTO;
import xyz.lagosoft.ideas.Challenges.vo.QuestionVO;

public interface QuestionService {

    QuestionVO createQuestion(QuestionDTO dto);

    QuestionVO retrieveQuestion(Long id);

}
