package xyz.lagosoft.ideas.Projects.service;

import xyz.lagosoft.ideas.Projects.model.Stack;

import java.util.List;

public interface StackService {

    List<Stack> retrieveAllStacks();

    List<Stack> retrieveStacksBySlugs(List<String> slugs);

}
