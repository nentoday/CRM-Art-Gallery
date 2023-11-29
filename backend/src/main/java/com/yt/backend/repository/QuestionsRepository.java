package com.yt.backend.repository;

import com.yt.backend.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByQuestion(String question);

}
