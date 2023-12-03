package xyz.lagosoft.ideas.Challenges.vo;

import xyz.lagosoft.ideas.Challenges.model.Question;
import xyz.lagosoft.ideas.Builders.vo.CommentVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionVO {

    private Long id;

    private Long collectiveId;

    private BuilderVO author;

    private String title;

    private String body;

    private Date createdAt;

    private Integer answersCount;

    private List<AnswerVO> answers = new ArrayList<>();

    private Integer commentsCount;

    private List<CommentVO> comments = new ArrayList<>();

    public QuestionVO(Question question) {
        BeanUtils.copyProperties(question, this);
        this.author = question.getAuthorVO();
        this.answersCount = question.getAnswersCount();
        this.answers = question.getAnswerList();
        this.commentsCount = question.getCommentsCount();
        this.comments = question.getCommentList();
    }

    public QuestionVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCollectiveId() {
        return collectiveId;
    }

    public void setCollectiveId(Long collectiveId) {
        this.collectiveId = collectiveId;
    }

    public BuilderVO getAuthor() {
        return author;
    }

    public void setAuthor(BuilderVO author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAnswersCount() {
        return answersCount;
    }

    public void setAnswersCount(Integer answersCount) {
        this.answersCount = answersCount;
    }

    public List<AnswerVO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerVO> answers) {
        this.answers = answers;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }
}
