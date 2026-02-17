package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.Paper;
import com.MahaTest.Entity.Subject;
import com.MahaTest.Repository.PaperRepository;
import com.MahaTest.Repository.SubjectRepository;
import com.MahaTest.Service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaperServiceImpl implements PaperService {

    private final PaperRepository paperRepository;
    private final SubjectRepository subjectRepository;

    // Create
    @Override
    public Paper createPaper(Paper paper) {

        Long subjectId = paper.getSubject().getId();

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + subjectId));

        paper.setSubject(subject);

        return paperRepository.save(paper);
    }

    // Update
    @Override
    public Paper updatePaper(Long id, Paper paper) {

        Paper existing = paperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paper not found with id: " + id));

        existing.setName(paper.getName());
        existing.setTotalQuestions(paper.getTotalQuestions());
        existing.setTotalMarks(paper.getTotalMarks());
        existing.setDurationMinutes(paper.getDurationMinutes());
        existing.setYear(paper.getYear());
        existing.setActive(paper.isActive());

        // Update Subject if changed
        Long subjectId = paper.getSubject().getId();

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + subjectId));

        existing.setSubject(subject);

        return paperRepository.save(existing);
    }

    //  Get All
    @Override
    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    @Override
    public List<Paper> getPapersBySubjectId(Long subjectId) {
        return paperRepository.findBySubjectId(subjectId);
    }


    // Get By id
    @Override
    public Paper getPaperById(Long id) {
        return paperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paper not found with id: " + id));
    }

    //  Delete
    @Override
    public void deletePaper(Long id) {

        Paper paper = paperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paper not found with id: " + id));

        paperRepository.delete(paper);
    }
}
