package xyz.lagosoft.ideas.Projects.service;

import xyz.lagosoft.ideas.Projects.dto.UpdateDTO;
import xyz.lagosoft.ideas.Projects.model.Update;

public interface UpdateService {

    Update createUpdate(UpdateDTO dto);

    Update retrieveUpdate(Long id);

}