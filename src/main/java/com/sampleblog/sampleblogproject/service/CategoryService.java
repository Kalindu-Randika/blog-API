package com.sampleblog.sampleblogproject.service;

import com.sampleblog.sampleblogproject.payload.CategoryDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId) throws ChangeSetPersister.NotFoundException;

    List<CategoryDto> getAllCategories();
}
