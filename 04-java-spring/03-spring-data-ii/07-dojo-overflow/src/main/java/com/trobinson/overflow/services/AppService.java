package com.trobinson.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trobinson.overflow.models.Answer;
import com.trobinson.overflow.models.Question;
import com.trobinson.overflow.models.QuestionTag;
import com.trobinson.overflow.models.Tag;
import com.trobinson.overflow.repositories.AnswerRepository;
import com.trobinson.overflow.repositories.QuestionRepository;
import com.trobinson.overflow.repositories.TagRepository;

@Service
public class AppService {

	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private TagRepository tRepo;
	
	@Autowired
	private AnswerRepository aRepo;
    
    //Methods
    
    // Retrieve All
    public List<Question> findAllQuestions() {
        return this.qRepo.findAll();
    }
    public List<Answer> findAllAnswers() {
        return this.aRepo.findAll();
    }
    public List<Tag> findAllTags() {
        return this.tRepo.findAll();
    }
    
    // Create Question
	public void createQuestionTag(QuestionTag questionTag) {
		
		Question newQuestion = new Question(questionTag.getQuestion_asked());
		Question question = qRepo.save(newQuestion);
		
		String[] splitSubject = questionTag.getSubject().split(",\\s*");
		List<Tag> tagList = new ArrayList<Tag>();
		
		for(int i = 0; i < splitSubject.length; i++) {	
			Tag findTag = tRepo.findBySubject(splitSubject[i]).orElse(null);
			if (findTag == null) {
				Tag newTag = new Tag(splitSubject[i]);
				tagList.add(newTag);
			} else {
				tagList.add(findTag);
			}
		}
		question.setTags(tagList);
		qRepo.save(question);

	}
	
    // Read - Find One
    public Question findOneQuestion(Long id) {
        return this.qRepo.findById(id).orElse(null);
    }
    
    // Create Answer
	public void createAnswer(Answer answer, Long questionId) {
		
		Question question = qRepo.findById(questionId).orElse(null);
		
		Answer newAnswer = new Answer(answer);
		
		question.addAnswer(newAnswer);
		newAnswer.setQuestion(question);
		
		aRepo.save(newAnswer);
		
	}
}








