package xyz.lagosoft.ideas.Builders.service;

import xyz.lagosoft.ideas.Builders.dto.BuilderProfileDTO;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.vo.BuilderProfileVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;

import java.util.List;

public interface BuilderService {

    List<BuilderVO> retrieveAllBuilders();

    Builder retrieveBuilder(String username);

    List<Builder> retrieveBuildersByUsernames(List<String> usernames);

    Builder getCurrentBuilder();

    BuilderProfileVO retrieveBuilderProfile(String username);

    BuilderProfileVO updateBuilderProfile(BuilderProfileDTO dto);

}
