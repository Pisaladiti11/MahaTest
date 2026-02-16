package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.Paper;
import com.MahaTest.Entity.Question;
import com.MahaTest.Repository.PaperRepository;
import com.MahaTest.Repository.QuestionRepository;
import com.MahaTest.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final PaperRepository paperRepository;

    // ✅ Create
    @Override
    public Question createQuestion(Question question) {

        Long paperId = question.getPaper().getId();

        Paper paper = paperRepository.findById(paperId)
                .orElseThrow(() -> new RuntimeException("Paper not found with id: " + paperId));

        question.setPaper(paper);

        return questionRepository.save(question);
    }

    // ✅ Update
    @Override
    public Question updateQuestion(Long id, Question question) {

        Question existing = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

        existing.setQuestionText(question.getQuestionText());
        existing.setOptionA(question.getOptionA());
        existing.setOptionB(question.getOptionB());
        existing.setOptionC(question.getOptionC());
        existing.setOptionD(question.getOptionD());
        existing.setCorrectAnswer(question.getCorrectAnswer());
        existing.setMarks(question.getMarks());
        existing.setNegativeMarks(question.getNegativeMarks());
        existing.setDifficultyLevel(question.getDifficultyLevel());
        existing.setTopic(question.getTopic());
        existing.setExplanation(question.getExplanation());
        existing.setActive(question.isActive());

        // Update Paper if changed
        Long paperId = question.getPaper().getId();

        Paper paper = paperRepository.findById(paperId)
                .orElseThrow(() -> new RuntimeException("Paper not found with id: " + paperId));

        existing.setPaper(paper);

        return questionRepository.save(existing);
    }

    // ✅ Get All
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // ✅ Get By id
    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    // ✅ Delete
    @Override
    public void deleteQuestion(Long id) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

        questionRepository.delete(question);
    }
}
