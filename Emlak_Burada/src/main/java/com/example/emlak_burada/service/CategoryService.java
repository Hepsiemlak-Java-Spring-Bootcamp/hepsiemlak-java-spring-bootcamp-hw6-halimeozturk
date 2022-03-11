package com.example.emlak_burada.service;


import com.example.emlak_burada.dto.CategoryDTO;
import com.example.emlak_burada.exception.GenericServiceException;
import com.example.emlak_burada.mapper.CategoryMapper;
import com.example.emlak_burada.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllList() {
        return categoryMapper.toDTOList(categoryRepository.findAll());
    }

    @Transactional
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toEntity(categoryDTO)));
    }

    @Transactional
    public CategoryDTO update(CategoryDTO categoryDTO) {
        getById(categoryDTO.getId());
        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toEntity(categoryDTO)));
    }

    public CategoryDTO getById(Long id){
        return categoryMapper.toDTO(categoryRepository.findById(id).orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Category not found")));
    }
}
