package com.MahaTest.Service;

import com.MahaTest.Entity.Paper;

import java.util.List;

public interface PaperService {

    Paper createPaper(Paper paper);

    Paper updatePaper(Long id, Paper paper);

    List<Paper> getAllPapers();

    List<Paper> getPapersBySubjectId(Long subjectId);


    Paper getPaperById(Long id);

    void deletePaper(Long id);
}
