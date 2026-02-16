package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.Category;
import com.MahaTest.Entity.TestSeries;
import com.MahaTest.Repository.CategoryRepository;
import com.MahaTest.Repository.TestSeriesRepository;
import com.MahaTest.Service.TestSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestSeriesServiceImpl implements TestSeriesService {

    private final TestSeriesRepository testSeriesRepository;
    private final CategoryRepository categoryRepository;

    // ✅ Create
    @Override
    public TestSeries createTestSeries(TestSeries testSeries) {

        // 🔥 Very Important: Validate Category
        Long categoryId = testSeries.getCategory().getId();

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        testSeries.setCategory(category);

        return testSeriesRepository.save(testSeries);
    }

    // ✅ Update
    @Override
    public TestSeries updateTestSeries(Long id, TestSeries testSeries) {

        TestSeries existing = testSeriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestSeries not found with id: " + id));

        existing.setName(testSeries.getName());
        existing.setExamType(testSeries.getExamType());
        existing.setTotalMarks(testSeries.getTotalMarks());
        existing.setDurationMinutes(testSeries.getDurationMinutes());
        existing.setActive(testSeries.isActive());

        // Update Category if changed
        Long categoryId = testSeries.getCategory().getId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        existing.setCategory(category);

        return testSeriesRepository.save(existing);
    }

    // ✅ Get All
    @Override
    public List<TestSeries> getAllTestSeries() {
        return testSeriesRepository.findAll();
    }

    // ✅ Get By id
    @Override
    public TestSeries getTestSeriesById(Long id) {
        return testSeriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestSeries not found with id: " + id));
    }

    // ✅ Delete
    @Override
    public void deleteTestSeries(Long id) {

        TestSeries testSeries = testSeriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestSeries not found with id: " + id));

        testSeriesRepository.delete(testSeries);
    }
}
