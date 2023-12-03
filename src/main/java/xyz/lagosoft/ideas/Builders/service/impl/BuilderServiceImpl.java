package xyz.lagosoft.ideas.Builders.service.impl;

import xyz.lagosoft.ideas.Auth.AuthService;
import xyz.lagosoft.ideas.Builders.dto.BuilderProfileDTO;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.repository.BuilderRepository;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import xyz.lagosoft.ideas.Builders.vo.BuilderProfileVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BuilderServiceImpl implements BuilderService {

    @Autowired
    private BuilderRepository builderRepository;

    @Autowired
    private AuthService authService;

    public Builder retrieveBuilder(String username) {
        Builder builder = Optional.ofNullable(builderRepository.findByUsername(username)).orElseThrow(NotFoundException::new);
        return builder;
    }

    public List<Builder> retrieveBuildersByUsernames(List<String> usernames) {
        List<Builder> builders = new ArrayList<>();
        for (String username : usernames) {
            Builder builder = retrieveBuilder(username);
            builders.add(builder);
        }
        return builders;
    }

    public List<BuilderVO> retrieveAllBuilders() {
        return convertToBuilderVOs(builderRepository.findAll());
    }

    public Builder getCurrentBuilder() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if (username == null) throw new NotFoundException("Please Sign In First");
        return retrieveBuilder(username);
    }
    public BuilderProfileVO retrieveBuilderProfile(String username) {
        Builder builder = retrieveBuilder(username);
        return new BuilderProfileVO(builder);
    }

    public BuilderProfileVO updateBuilderProfile(BuilderProfileDTO dto) {
        Builder builder = getCurrentBuilder();
        BeanUtils.copyProperties(dto, builder);
        builderRepository.save(builder);
        return new BuilderProfileVO(builder);
    }

    private List<BuilderVO> convertToBuilderVOs(List<Builder> builders) {
        List<BuilderVO> builderVOS = new ArrayList<>();
        for (Builder builder : builders) {
            builderVOS.add(new BuilderVO(builder));
        }
        return builderVOS;
    }

}
