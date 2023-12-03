package xyz.lagosoft.ideas.Challenges.service;

import xyz.lagosoft.ideas.Challenges.dto.AnswerDTO;
import xyz.lagosoft.ideas.Challenges.vo.AnswerVO;

public interface AnswerService {

    AnswerVO createAnswer(AnswerDTO dto);

}
