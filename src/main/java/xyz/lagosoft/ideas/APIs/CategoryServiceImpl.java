package xyz.lagosoft.ideas.APIs;

import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryVO> retrieveAllCategories() {
        return convertToCategoryVOs(categoryRepository.findAll());
    }

    public CategoryVO retrieveCategory(String slug) {
        Category category = Optional.ofNullable(categoryRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
        return new CategoryVO(category);
    }

    private List<CategoryVO> convertToCategoryVOs(List<Category> categories) {
        List<CategoryVO> categoryVOs = new ArrayList<>();
        for (Category category : categories) {
            categoryVOs.add(new CategoryVO(category));
        }
        return categoryVOs;
    }

}
