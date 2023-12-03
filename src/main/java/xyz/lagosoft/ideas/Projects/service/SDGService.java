package xyz.lagosoft.ideas.Projects.service;

import xyz.lagosoft.ideas.Projects.model.SDG;

import java.util.List;

public interface SDGService {

    List<SDG> retrieveAllSDGs();

    List<SDG> retrieveSDGsBySlugs(List<String> slugs);

}
