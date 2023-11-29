package com.yt.backend.service;

import com.yt.backend.model.Questions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionsService {
    Questions getQuestionById(long id);
    List<Questions> getQuestions();
    List<Questions> findByQuestion(String question);
}
