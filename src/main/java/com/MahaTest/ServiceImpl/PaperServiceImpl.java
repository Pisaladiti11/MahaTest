package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.Paper;
import com.MahaTest.Entity.Section;
import com.MahaTest.Entity.Subject;
import com.MahaTest.Repository.PaperRepository;
import com.MahaTest.Repository.SectionRepository;
import com.MahaTest.Repository.SubjectRepository;
import com.MahaTest.Service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaperServiceImpl implements PaperService {

    private final PaperRepository paperRepository;
    private final SectionRepository sectionRepository;

    @Override
    public Paper createPaper(Paper paper) {

        List<Long> sectionIds = paper.getSections()
                .stream()
                .map(Section::getId)
                .toList();

        List<Section> sections =
                sectionRepository.findAllById(sectionIds);

        paper.setSections(sections);

        return paperRepository.save(paper);
    }

    @Override
    public Paper updatePaper(Long id, Paper paper) {

        Paper existing = paperRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paper not found"));

        existing.setName(paper.getName());
        existing.setTotalQuestions(paper.getTotalQuestions());
        existing.setTotalMarks(paper.getTotalMarks());
        existing.setDurationMinutes(paper.getDurationMinutes());
        existing.setYear(paper.getYear());
        existing.setDescription(paper.getDescription());
        existing.setSubjectQuestion(paper.getSubjectQuestion());
        existing.setActive(paper.isActive());

        List<Long> sectionIds = paper.getSections()
                .stream()
                .map(Section::getId)
                .toList();

        List<Section> sections =
                sectionRepository.findAllById(sectionIds);

        existing.setSections(sections);

        return paperRepository.save(existing);
    }

    @Override
    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    @Override
    public List<Paper> getPapersBySectionId(Long sectionId) {
        return paperRepository.findBySections_Id(sectionId);
    }

    @Override
    public Paper getPaperById(Long id) {
        return paperRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paper not found"));
    }

    @Override
    public void deletePaper(Long id) {

        Paper paper = paperRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paper not found"));

        paperRepository.delete(paper);
    }
}



