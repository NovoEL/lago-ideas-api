package xyz.lagosoft.ideas.Builders.service.impl;

import xyz.lagosoft.ideas.Challenges.model.Answer;
import xyz.lagosoft.ideas.Challenges.model.Question;
import xyz.lagosoft.ideas.Challenges.repository.AnswerRepository;
import xyz.lagosoft.ideas.Challenges.repository.QuestionRepository;
import xyz.lagosoft.ideas.Projects.model.SideProject;
import xyz.lagosoft.ideas.Projects.repository.SideProjectRepository;
import xyz.lagosoft.ideas.Builders.dto.CommentDTO;
import xyz.lagosoft.ideas.Builders.model.Comment;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.repository.CommentRepository;
import xyz.lagosoft.ideas.Builders.service.CommentService;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import xyz.lagosoft.ideas.Builders.vo.CommentVO;
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
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private SideProjectRepository projectRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private BuilderService builderService;

    public CommentVO createComment(CommentDTO dto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(dto, comment);
        comment.setAuthor(builderService.getCurrentBuilder());
        comment.setCreatedAt(new Date());
        commentRepository.save(comment);
        switch (comment.getCommentableType()) {
            case PROJECT:
                SideProject project = projectRepository.findById(comment.getCommentableId()).orElseThrow(NotFoundException::new);
                project.addComment(comment);
                break;
            case QUESTION:
                Question question = questionRepository.findById(comment.getCommentableId()).orElseThrow(NotFoundException::new);
                question.addComment(comment);
                break;
            case ANSWER:
                Answer answer = answerRepository.findById(comment.getCommentableId()).orElseThrow(NotFoundException::new);
                answer.addComment(comment);
                break;
        }
        return new CommentVO(comment);
    }

    public List<CommentVO> retrieveCommentsByAuthor(String username) {
        Builder author = builderService.retrieveBuilder(username);
        List<Comment> comments = commentRepository.findAllByAuthor(author);
        return convertToCommentVOs(comments);
    }

    public Comment retrieveComment(Long id) {
        return commentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public CommentVO updateComment(Long id, CommentDTO dto) {
        Comment comment = retrieveComment(id);
        BeanUtils.copyProperties(dto, comment);
        commentRepository.save(comment);
        return new CommentVO(comment);
    }
    public void deleteComment(Long id) {
        Comment comment = retrieveComment(id);
        switch (comment.getCommentableType()) {
            case PROJECT:
                SideProject project = projectRepository.findById(comment.getCommentableId()).orElseThrow(NotFoundException::new);
                project.removeComment(comment);
                break;
            case QUESTION:
                Question question = questionRepository.findById(comment.getCommentableId()).orElseThrow(NotFoundException::new);
                question.removeComment(comment);
                break;
            case ANSWER:
                Answer answer = answerRepository.findById(comment.getCommentableId()).orElseThrow(NotFoundException::new);
                answer.removeComment(comment);
                break;
        }
        commentRepository.delete(comment);
    }

    private List<CommentVO> convertToCommentVOs(List<Comment> comments) {
        List<CommentVO> commentVOs = new ArrayList<>();
        for (Comment comment : comments) {
            commentVOs.add(new CommentVO(comment));
        }
        return commentVOs;
    }

}
