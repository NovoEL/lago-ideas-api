package xyz.lagosoft.ideas.Projects.service.impl;

import xyz.lagosoft.ideas.Projects.repository.StackRepository;
import xyz.lagosoft.ideas.Projects.service.StackService;
import xyz.lagosoft.ideas.Projects.model.Stack;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StackServiceImpl implements StackService {

    @Autowired
    private StackRepository stackRepository;

    public List<Stack> retrieveAllStacks() {
        return stackRepository.findAll();
    }

    public List<Stack> retrieveStacksBySlugs(List<String> slugs) {
        List<Stack> stacks = new ArrayList<>();
        for (String slug : slugs) {
            Stack stack = Optional.ofNullable(stackRepository.findBySlug(slug)).orElseThrow(NotFoundException::new);
            stacks.add(stack);
        }
        return stacks;
    }

}
