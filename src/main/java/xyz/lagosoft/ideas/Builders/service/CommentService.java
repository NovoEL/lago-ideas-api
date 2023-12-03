package xyz.lagosoft.ideas.Builders.service;

import xyz.lagosoft.ideas.Builders.dto.CommentDTO;
import xyz.lagosoft.ideas.Builders.model.Comment;
import xyz.lagosoft.ideas.Builders.vo.CommentVO;

import java.util.List;

public interface CommentService {

    CommentVO createComment(CommentDTO dto);

    List<CommentVO> retrieveCommentsByAuthor(String username);

    Comment retrieveComment(Long id);

    CommentVO updateComment(Long id, CommentDTO dto);

    void deleteComment(Long id);

}
