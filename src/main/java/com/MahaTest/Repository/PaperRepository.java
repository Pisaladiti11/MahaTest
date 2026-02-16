package com.MahaTest.Repository;

import com.MahaTest.Entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<Paper,Long  > {
}
