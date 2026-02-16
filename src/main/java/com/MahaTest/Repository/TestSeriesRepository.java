package com.MahaTest.Repository;

import com.MahaTest.Entity.TestSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSeriesRepository extends JpaRepository<TestSeries, Long> {
}
