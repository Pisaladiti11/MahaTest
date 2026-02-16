package com.MahaTest.Service;

import com.MahaTest.Entity.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    Question updateQuestion(Long id, Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(Long id);

    void deleteQuestion(Long id);
}
