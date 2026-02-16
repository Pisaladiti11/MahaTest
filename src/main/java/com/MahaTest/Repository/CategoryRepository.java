package com.MahaTest.Repository;

import com.MahaTest.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long  > {
    boolean existsByName(String name);
}
