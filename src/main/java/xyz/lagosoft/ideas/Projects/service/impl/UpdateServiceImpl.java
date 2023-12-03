package xyz.lagosoft.ideas.Projects.service.impl;

import xyz.lagosoft.ideas.Projects.dto.UpdateDTO;
import xyz.lagosoft.ideas.Projects.model.Update;
import xyz.lagosoft.ideas.Projects.repository.UpdateRepository;
import xyz.lagosoft.ideas.Projects.service.UpdateService;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.Date;

@Service
@Transactional
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateRepository updateRepository;

    public Update createUpdate(UpdateDTO dto) {
        Update update = new Update(dto);
        update.setCreatedAt(new Date());
        updateRepository.save(update);
        return update;
    }

    public Update retrieveUpdate(Long id) {
        Update update = updateRepository.findById(id).orElseThrow(NotFoundException::new);
        return update;
    }

}
