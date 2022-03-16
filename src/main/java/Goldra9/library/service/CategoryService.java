package Goldra9.library.service;

import Goldra9.library.domain.Category;
import Goldra9.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void save(Category category)
    {
        categoryRepository.save(category);
    }

    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id)
    {
        return categoryRepository.findById(id);
    }
}
