package com.sampleblog.sampleblogproject.controller;

import com.sampleblog.sampleblogproject.entity.Category;
import com.sampleblog.sampleblogproject.payload.CategoryDto;
import com.sampleblog.sampleblogproject.service.CategoryService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    //Build add category rest API
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping("{categoryId}   ")
    //Build get category rest API
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long categoryId) throws ChangeSetPersister.NotFoundException {
        CategoryDto categoryDto = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    //Build get all categories rest API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    //Build update category rest API

    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDto> updatedCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long categoryId) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, categoryId));
    }
}
