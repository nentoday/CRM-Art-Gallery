package com.yt.backend.controller;

import com.yt.backend.model.Questions;
import com.yt.backend.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {

    @Autowired
    private QuestionsService questionsService;

    @RequestMapping("/q-a/{id}")
    public Questions getQuestionById(@PathVariable("id") long id){
        return questionsService.getQuestionById(id);
    }

    @RequestMapping("/q-a")
    public List<Questions> getQuestions(){
        return questionsService.getQuestions();
    }

}
