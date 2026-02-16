package com.MahaTest.Controller;

import com.MahaTest.Entity.Question;
import com.MahaTest.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    // ✅ Create
    @PostMapping("/createQuestion")
    public ResponseEntity<Question> create(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.createQuestion(question));
    }

    // ✅ Update
    @PutMapping("updateQuestionById/{id}")
    public ResponseEntity<Question> update(
            @PathVariable Long id,
            @RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(id, question));
    }

    // ✅ Get All
    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAll() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    // ✅ Get By id
    @GetMapping("getQuestionById/{id}")
    public ResponseEntity<Question> getById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    // ✅ Delete
    @DeleteMapping("DeleteQuestion/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Question deleted successfully");
    }
}

