package com.MahaTest.Service;

import com.MahaTest.Entity.TestSeries;

import java.util.List;

public interface TestSeriesService {

    TestSeries createTestSeries(TestSeries testSeries);

    TestSeries updateTestSeries(Long id, TestSeries testSeries);

    List<TestSeries> getAllTestSeries();

    TestSeries getTestSeriesById(Long id);

    void deleteTestSeries(Long id);
}
