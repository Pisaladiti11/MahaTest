package com.MahaTest.Repository;

import com.MahaTest.Entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper,Long  > {
      List<Paper>  findBySubjectId(Long subjectId);

}
