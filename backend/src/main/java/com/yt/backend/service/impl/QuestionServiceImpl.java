package com.yt.backend.service.impl;

import com.yt.backend.model.Questions;
import com.yt.backend.repository.QuestionsRepository;
import com.yt.backend.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;
    @Override
    public Questions getQuestionById(long id) {
        return questionsRepository.findById(id).get();
    }

    @Override
    public List<Questions> getQuestions() {
        return (List<Questions>) questionsRepository.findAll();
    }

    @Override
    public List<Questions> findByQuestion(String question) {
        return questionsRepository.findByQuestion(question);
    }
}
