package com.sampleblog.sampleblogproject.service.impl;

import com.sampleblog.sampleblogproject.entity.Category;
import com.sampleblog.sampleblogproject.exception.ResourceNotFoundExtension;
import com.sampleblog.sampleblogproject.payload.CategoryDto;
import com.sampleblog.sampleblogproject.repository.CategoryRepository;
import com.sampleblog.sampleblogproject.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) throws ChangeSetPersister.NotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
       List<Category> categories = categoryRepository.findAll();
        return (List<CategoryDto>) categories.stream().map((category -> modelMapper.map(category, CategoryDto.class)));
    }
}
