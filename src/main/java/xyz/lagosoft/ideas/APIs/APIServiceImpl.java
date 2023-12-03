package xyz.lagosoft.ideas.APIs;

import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class APIServiceImpl implements APIService {
    @Autowired
    private AwesomeAPIRepository awesomeAPIRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<AwesomeAPI> retrieveAllAPIs() {
        return awesomeAPIRepository.findAll();
    }

    public List<AwesomeAPI> retrieveAPIsByCategory(String slug) {
        Category category = Optional.ofNullable(categoryRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
        return List.copyOf(category.getApis());
    }
    public AwesomeAPI retrieveAPI(String slug) {
        AwesomeAPI api = Optional.ofNullable(awesomeAPIRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
        return api;
    }

    public List<AwesomeAPI> retrieveAPIsBySlugs(List<String> slugs) {
        List<AwesomeAPI> apis = new ArrayList<>();
        for (String slug : slugs) {
            AwesomeAPI api = Optional.ofNullable(awesomeAPIRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
            apis.add(api);
        }
        return apis;
    }

}
