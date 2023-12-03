package xyz.lagosoft.ideas.Projects.service.impl;

import xyz.lagosoft.ideas.Projects.model.SDG;
import xyz.lagosoft.ideas.Projects.repository.SDGRepository;
import xyz.lagosoft.ideas.Projects.service.SDGService;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SDGServiceImpl implements SDGService {

    @Autowired
    private SDGRepository sdgRepository;

    public List<SDG> retrieveAllSDGs() {
        return sdgRepository.findAll();
    }

    public List<SDG> retrieveSDGsBySlugs(List<String> slugs) {
        List<SDG> sdgs = new ArrayList<>();
        for (String slug : slugs) {
            SDG sdg = Optional.ofNullable(sdgRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
            sdgs.add(sdg);
        }
        return sdgs;
    }

}
