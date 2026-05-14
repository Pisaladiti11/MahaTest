package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.Paper;
import com.MahaTest.Entity.Question;
import com.MahaTest.Entity.Section;
import com.MahaTest.Repository.PaperRepository;
import com.MahaTest.Repository.QuestionRepository;
import com.MahaTest.Repository.SectionRepository;
import com.MahaTest.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final PaperRepository paperRepository;
    private final SectionRepository sectionRepository;

    // CREATE
    @Override
    public Question createQuestion(Question question) {

        // Validate Paper
        Long paperId = question.getPaper().getId();

        Paper paper = paperRepository.findById(paperId)
                .orElseThrow(() ->
                        new RuntimeException("Paper not found with id: " + paperId));

        // Validate Section
        Long sectionId = question.getSection().getId();

        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() ->
                        new RuntimeException("Section not found with id: " + sectionId));

        question.setPaper(paper);
        question.setSection(section);

        return questionRepository.save(question);
    }

    // UPDATE
    @Override
    public Question updateQuestion(Long id, Question question) {

        Question existing = questionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Question not found with id: " + id));

        existing.setQuestionText(question.getQuestionText());
        existing.setQuestionImage(question.getQuestionImage());

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

        existing.setQuestionType(question.getQuestionType());

        existing.setActive(question.isActive());

        // Update Paper
        Long paperId = question.getPaper().getId();

        Paper paper = paperRepository.findById(paperId)
                .orElseThrow(() ->
                        new RuntimeException("Paper not found with id: " + paperId));

        existing.setPaper(paper);

        // Update Section
        Long sectionId = question.getSection().getId();

        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() ->
                        new RuntimeException("Section not found with id: " + sectionId));

        existing.setSection(section);

        return questionRepository.save(existing);
    }

    // GET ALL
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // GET BY ID
    @Override
    public Question getQuestionById(Long id) {

        return questionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Question not found with id: " + id));
    }

    // DELETE
    @Override
    public void deleteQuestion(Long id) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Question not found with id: " + id));

        questionRepository.delete(question);
    }
}