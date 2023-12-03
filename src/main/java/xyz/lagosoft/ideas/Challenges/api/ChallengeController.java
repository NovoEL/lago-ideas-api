package xyz.lagosoft.ideas.Challenges.api;

import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.Challenges.service.ChallengeService;
import xyz.lagosoft.ideas.Challenges.service.ChallengeFollowService;
import xyz.lagosoft.ideas.Challenges.vo.ChallengeVO;
import xyz.lagosoft.ideas.Challenges.dto.AnswerDTO;
import xyz.lagosoft.ideas.Challenges.dto.QuestionDTO;
import xyz.lagosoft.ideas.Challenges.service.AnswerService;
import xyz.lagosoft.ideas.Challenges.service.QuestionService;
import xyz.lagosoft.ideas.Challenges.vo.QuestionVO;
import xyz.lagosoft.ideas.Projects.dto.ChallengeEntryDTO;
import xyz.lagosoft.ideas.Projects.service.ProjectService;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/challenges")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private ChallengeFollowService followService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @PostMapping("/{slug}/entries")
    public ResponseEntity<Void> newChallengeEntry(@PathVariable String slug, @RequestBody ChallengeEntryDTO request) {
        request.setChallengeSlug(slug);
        projectService.createChallengeEntry(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{slug}/questions")
    public ResponseEntity<Void> newQuestion(@PathVariable String slug, @RequestBody QuestionDTO request) {
        //TODO check permission
        ChallengeVO challenge = challengeService.retrieveChallenge(slug);
        request.setChallengeId(challenge.getId());
        questionService.createQuestion(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{slug}/questions/{id}/answers")
    public ResponseEntity<Void> newAnswer(@PathVariable String slug, @PathVariable Long id, @RequestBody AnswerDTO request) {
        //TODO check permission
        ChallengeVO challenge = challengeService.retrieveChallenge(slug);
        request.setChallengeId(challenge.getId());
        QuestionVO question = questionService.retrieveQuestion(id);
        request.setQuestionId(question.getId());
        answerService.createAnswer(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{slug}/followers")
    public ResponseEntity<Void> follow(@PathVariable String slug) {
        followService.follow(slug);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ChallengeVO>> getAllChallenges() {
        List<ChallengeVO> challenges = challengeService.retrieveAllChallenges();
        return new ResponseEntity<>(challenges, HttpStatus.OK);
    }
    @GetMapping("/{slug}")
    public ResponseEntity<ChallengeVO> getChallenge(@PathVariable String slug) {
        ChallengeVO challenge = challengeService.retrieveChallenge(slug);
        return new ResponseEntity<>(challenge, HttpStatus.OK);
    }

    @GetMapping("/{slug}/followers")
    public ResponseEntity<List<BuilderVO>> getChallengeFollowers(@PathVariable String slug) {
        List<BuilderVO> followers = challengeService.retrieveChallengeFollowers(slug);
        return new ResponseEntity<>(followers, HttpStatus.OK);
    }

    @GetMapping("/{slug}/questions")
    public ResponseEntity<List<QuestionVO>> getChallengeQuestions(@PathVariable String slug) {
        List<QuestionVO> questions = challengeService.retrieveChallengeQuestions(slug);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{slug}/entries")
    public ResponseEntity<List<ProjectVO>> getChallengeEntries(@PathVariable String slug) {
        List<ProjectVO> entries = challengeService.retrieveChallengeEntries(slug);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

}
