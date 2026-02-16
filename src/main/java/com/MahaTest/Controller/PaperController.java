package com.MahaTest.Controller;

import com.MahaTest.Entity.Paper;
import com.MahaTest.Service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/papers")
@RequiredArgsConstructor
public class PaperController {

    private final PaperService paperService;

    // ✅ Create
    @PostMapping("/CreatePaper")
    public ResponseEntity<Paper> create(@RequestBody Paper paper) {
        return ResponseEntity.ok(paperService.createPaper(paper));
    }

    // ✅ Update
    @PutMapping("getPaperById/{id}")
    public ResponseEntity<Paper> update(
            @PathVariable Long id,
            @RequestBody Paper paper) {
        return ResponseEntity.ok(paperService.updatePaper(id, paper));
    }

    // ✅ Get All
    @GetMapping("/GetAllPapers")
    public ResponseEntity<List<Paper>> getAll() {
        return ResponseEntity.ok(paperService.getAllPapers());
    }

    // Get By id
    @GetMapping("/getPaperById/{id}")
    public ResponseEntity<Paper> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paperService.getPaperById(id));
    }

    // ✅ Delete
    @DeleteMapping("/DeletePaper/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        paperService.deletePaper(id);
        return ResponseEntity.ok("Paper deleted successfully");
    }
}
