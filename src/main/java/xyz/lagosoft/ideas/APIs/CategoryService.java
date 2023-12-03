package xyz.lagosoft.ideas.APIs;

import java.util.List;

public interface CategoryService {

    List<CategoryVO> retrieveAllCategories();

    CategoryVO retrieveCategory(String slug);

}
