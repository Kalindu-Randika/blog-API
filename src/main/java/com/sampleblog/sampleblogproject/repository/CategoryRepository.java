package com.sampleblog.sampleblogproject.repository;

import com.sampleblog.sampleblogproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
